import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {MedicalReport} from "./medicalReport";

@Injectable({
  providedIn: 'root'
})
export class MedicalReportService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T){
    return (error:any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

  addMedRep(medRep: MedicalReport){

  }
}
