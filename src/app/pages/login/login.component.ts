import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule,HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ToastrService } from 'ngx-toastr';
import { User } from '../../class/User';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,
    HttpClientModule,CommonModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  isValid =true;
  //isEmpty = true;
  errorMessage=""
  user:User;

  
  constructor(private http:HttpClient,private toastr: ToastrService, private router : Router ){
    this.user = new User();
  }

  showSuccess() {
    this.toastr.success('Hello world!', 'Toastr fun!');
  }

  onLogin(){
    if(this.user.email !="" && this.user.password !=""){
      //this.isEmpty = false;
    this.http.post("http://localhost:8080/api/v1/auth/signin",this.user).subscribe((response:any)=>{
      console.log(this.user);
      this.isValid =true;
      console.log("response :: "+response.refreshToken)
      localStorage.setItem("loginToken", response.refreshToken)
      this.router.navigateByUrl("/dashboard");

    },(err:any)=>{
      if(err.error !=null){
        this.isValid =false;
      }
      console.log("Error "+err.error.message)
      this.errorMessage=err.error.message;
      this.showSuccess();
    })
  }else{
    //this.isEmpty =true;
  }
  }

}
