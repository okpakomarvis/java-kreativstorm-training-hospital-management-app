
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CurrentUser } from '../../class/User';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  user:CurrentUser;
  constructor(private http:HttpClient){
    this.user =new CurrentUser();
    this.loadUser();
  }

  loadUser(){
    //debugger;
    this.http.get("http://localhost:8080/api/v1/user/current-user").subscribe((response:any)=>{
      console.log(this.user);
      this.user =response;
      console.log("response :: "+response)
      //localStorage.setItem("loginToken", response.refreshToken)

    })
  }
}
