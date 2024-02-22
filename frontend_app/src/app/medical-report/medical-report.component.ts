import {Component, OnInit} from '@angular/core';
import {MedicalReport} from "../medicalReport";
import {MedicalReportService} from "../medical-report.service";
import {User} from "../user";
import {UsersService} from "../users.service";

@Component({
  selector: 'app-medical-report',
  templateUrl: './medical-report.component.html',
  styleUrls: ['./medical-report.component.css']
})
export class MedicalReportComponent implements OnInit{
  public medicalReport: MedicalReport | undefined;
  public patients: User[] | undefined;

  constructor(private medRepService: MedicalReportService, private  usersService: UsersService) {
  }

  ngOnInit() {
  }

  refresh(){
    this.ngOnInit();
  }

  addMedRep(name: string, patientID: number, doctorID: number, treatmentID: string | undefined,
            diagnosis: string, prescription: string)
  {
    name = name.trim();
    diagnosis = diagnosis.trim();
    prescription = prescription.trim();
    if(!name || !patientID || !doctorID || !diagnosis || !prescription)
      return;
    let date = Date.now();
    this.medRepService.addMedRep({name, patientID, doctorID, treatmentID, date , diagnosis, prescription} as MedicalReport)
  }
  public getAllPatientsWithID(id: number){
    this.usersService.getAllPatientsWithID(id).subscribe(patients =>{
      this.patients = patients;
    })
  }

  protected readonly Number = Number;
}
