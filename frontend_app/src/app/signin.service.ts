import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {User} from "./user";
import {SignUpRequest} from "./sign-up-request";

@Injectable({
  providedIn: 'root'
})
export class SigninService {

  private userURL = "http://localhost:8080/api/v1/auth";
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

  signIn(user: User): Observable<User>{
    return this.http.post<User>(this.userURL + '/signin', user).pipe(
      tap(_ => console.log('fetched user')),
      catchError(this.handleError<User>('sign in', undefined))
    );
  }

  signUp(signUpReq : SignUpRequest){
    this.http.post(this.userURL + '/signup', signUpReq);
    /*.pipe(
      tap(_ => console.log('signed up')),
      catchError(this.handleError<User>('sign up', undefined))
    )*/

  }
}
