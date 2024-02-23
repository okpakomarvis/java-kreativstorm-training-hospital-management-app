import { Injectable } from '@angular/core';
import {Department} from "./department";
import {catchError, Observable, of, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private departmentURL = 'http://localhost:8080/hms/departments';
  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T){
    return (error:any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

  getDepartments(): Observable<Department[]>{
    return this.http.get<Department[]>(this.departmentURL).pipe(
      tap(_ => console.log('fetched departments')),
      catchError(this.handleError<Department[]>('departments', [])));
  }
}
