import {Component, OnInit} from '@angular/core';
import {Observable, of} from "rxjs";
import {TreatmentService} from "../treatment.service";
import {Treatment} from "../treatment";

@Component({
  selector: 'app-treatment',
  templateUrl: './treatment.component.html',
  styleUrls: ['./treatment.component.css']
})
export class TreatmentComponent implements OnInit {
  constructor(private treatmentService: TreatmentService) {
  }

  ngOnInit() {
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

  public addTreatment(medRepID: number, departmentID: number, description: string) {
    this.treatmentService.addTreatment({medRepID, departmentID, description} as Treatment)
  }
}
