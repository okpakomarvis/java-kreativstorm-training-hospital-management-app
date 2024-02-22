import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {SigninComponent} from "./signin/signin.component";
import {SignoutComponent} from "./signout/signout.component";
import {AppointmentComponent} from "./appointment/appointment.component";
import {DepartmentComponent} from "./department/department.component";
import {MedicalReportComponent} from "./medical-report/medical-report.component";
import {SignupComponent} from "./signup/signup.component";
import {PatientsComponent} from "./patients/patients.component";

const routes: Routes = [
  {path: 'signin', component:SigninComponent},
  {path: 'signout', component: SignoutComponent},
  {path: 'appointment', component: AppointmentComponent},
  {path: 'department', component: DepartmentComponent},
  {path: 'medicalReport', component: MedicalReportComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'patients', component: PatientsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
