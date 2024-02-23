import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SigninComponent } from './signin/signin.component';
import { SignoutComponent } from './signout/signout.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { DepartmentComponent } from './department/department.component';
import { MedicalReportComponent } from './medical-report/medical-report.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { SignupComponent } from './signup/signup.component';
import { PatientsComponent } from './patients/patients.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import {JwtInterceptorInterceptor} from "./jwt-interceptor.interceptor";
import { TreatmentComponent } from './treatment/treatment.component';

@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    SignoutComponent,
    AppointmentComponent,
    DepartmentComponent,
    MedicalReportComponent,
    SignupComponent,
    PatientsComponent,
    PatientDetailsComponent,
    TreatmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: JwtInterceptorInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
