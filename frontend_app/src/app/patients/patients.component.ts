import {Component, OnInit} from '@angular/core';
import {User} from "../user";
import {UsersService} from "../users.service";

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent implements OnInit{
  public patients: User[] | undefined;
  public selectedPatient: User | undefined;
  public allPatients: User[] | undefined;
  constructor(private usersService: UsersService) {
  }


  ngOnInit() {
    this.getAllPatients();
  }

  public getAllPatients(){
    this.usersService.getAllPatients().subscribe(patients =>{
      this.allPatients = patients;
      this.patients = patients;
    })
  }


  public onSelect(patient : User){
    this.selectedPatient = patient;
  }

  searchText: string = '';
  textChange(){
    this.patients = this.allPatients?.filter((val) => val.email.toLowerCase().includes(this.searchText.toLowerCase()))
  }
}
