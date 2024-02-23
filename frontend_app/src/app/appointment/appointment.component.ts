import {Component, OnInit} from '@angular/core';
import {AppointmentService} from "../appointment.service";
import {Observable, of} from "rxjs";
import {Appointment} from "../appointment";

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit{
  constructor(private appointmentService: AppointmentService) {
  }

  ngOnInit() {
  }

  private handleError<T>(operation = 'operation', result?: T){
    return (error:any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

  public addAppointment(patientID: number, doctorID: number, date: Date){
    this.appointmentService.addNewAppointment({patientID, doctorID, date} as Appointment)

  }

}
