import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {MedicalReport} from "./medicalReport";
import {Appointment} from "./appointment";

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private appointmentURL = "http://localhost:8080/api/v1/appointment"
  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T){
    return (error:any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

  addNewAppointment(appointment: Appointment){
    this.http.post(this.appointmentURL + "/save", appointment).pipe(
      tap(()=>console.log('Appointment added successfully.')),
      catchError(this.handleError<MedicalReport>('saveAppointment',undefined))
    );
  }
}
