import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {MedicalReport} from "./medicalReport";

@Injectable({
  providedIn: 'root'
})
export class MedicalReportService {
  private medRepURL: string = "http://localhost:8080/api/v1/medical"

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T){
    return (error:any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

  addMedRep(medRep: MedicalReport){
    this.http.post(this.medRepURL + "/save", medRep).pipe(
      tap(()=>console.log('Medical report added successfully.')),
      catchError(this.handleError<MedicalReport>('saveMedRep',undefined))
    );
  }
}
