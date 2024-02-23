import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {Appointment} from "./appointment";
import {MedicalReport} from "./medicalReport";
import {Treatment} from "./treatment";

@Injectable({
  providedIn: 'root'
})
export class TreatmentService {

  private treatmentURL = "http://localhost:8080/api/v1/treatments"
  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T){
    return (error:any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

  addTreatment(treatment: Treatment){
    this.http.post(this.treatmentURL + "/save", treatment).pipe(
      tap(()=>console.log('Treatment added successfully.')),
      catchError(this.handleError<MedicalReport>('saveTreatment',undefined))
    );
  }
}
