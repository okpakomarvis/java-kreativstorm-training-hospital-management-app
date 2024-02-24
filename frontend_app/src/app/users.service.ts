import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {User} from "./user";
import {Authority} from "./authority";

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  private userURL = "http://localhost:8080/";
  public currentUser: User | undefined;

  httpOptions = {
    headers:new HttpHeaders({'Content-Type': 'application/json'})
  }
  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T){
    return (error:any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

  getCurrentUser(): Observable<User>{
    return this.http.get<User>(this.userURL + '/current-user');
  }

  isRoleAdmin():boolean{
    if(this.currentUser){
      // @ts-ignore
      return this.currentUser.authorities.some((authority: string) => authority=== Authority.ADMIN);
    }
    else
      return false;
  }

  public getAllPatients(): Observable<User[]>{
    return this.http.get<User[]>(this.userURL).pipe(
      tap(_ => console.log('fetched patients')),
      catchError(this.handleError<User[]>('patients', []))
    );
  }

  public getAllPatientsWithID(id: number): Observable<User[]>{
    return this.http.get<User[]>(this.userURL + '/' + id).pipe(
      tap(_ => console.log('fetched patients')),
      catchError(this.handleError<User[]>('patients', []))
    );
  }
}
