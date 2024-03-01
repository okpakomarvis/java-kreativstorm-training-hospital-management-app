
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule,HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ErrorRegister, Register } from '../../class/User';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule,CommonModule,HttpClientModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
errorMessage="";
 user:Register;
 isValid =false;
 successMessage=""
 errors:ErrorRegister;
 constructor(private http:HttpClient){
  this.user =new Register();
  this.errors =new ErrorRegister();
 }

 onRegister(){
    this.http.post("http://localhost:8080/api/v1/auth/signup",this.user).subscribe(
    (res:any)=>{
      console.log("respone"+res.status)
      this.successMessage="Successfully Registered.";
    },(err:any)=>{
      if(err.error !=null){
        this.isValid =false;
        this.errors =err.error.errors;
        console.log("Error "+err.error.errors)
        console.log("Error message"+err.error.message)
        console.log("Error2 "+this.errors.email)
      //this.errorMessage=err.error.message;
      }
    
    });
  
 }
}
