
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Appointment, CurrentUser } from '../../class/User';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit{
  user:CurrentUser;
  appointment: Appointment[] =[];
  currentDay ="";

ngOnInit(){
   this.loadUser();
    this.loadAppointMent();
}
  constructor(private http:HttpClient){
    this.user =new CurrentUser();
  }
getCurrentMonth( month: number):string{
     const date = new Date();
      date.setMonth(month-1);
     return date.toLocaleString('en-US', {
    month: 'short',
  });
  }
getCurrentDay(year:number, month: number,day: number):string{
     const date = new Date(year+"-"+month+"-"+day);
     //date.setMonth(month)
     //date.setDate(day);
     let n = date.toLocaleString('en-US', {
        weekday:'long'
    });
    return n;

  }
  changeTimeFormat(hours:number, minute:number, mill:number) :string{
    let date = new Date();
      date.setHours(hours);
      date.setSeconds(minute)
      date.setMilliseconds(mill);
    let n = date.toLocaleString('en-US', {
        hour: '2-digit',
        minute: '2-digit'
    });
    return n;
}
 

  loadUser(){
    console.log("currentMonth in String : "+this.getCurrentMonth(9));
    console.log("currentDate in String : "+this.getCurrentDay(2023, 10, 2));
    console.log("currentTime in String : "+this.changeTimeFormat(20,40,3000));
    //debugger;
    this.http.get("http://localhost:8080/api/v1/user/current-user").subscribe((response:any)=>{
      console.log(this.user);
      this.user =response;
      if(this.loadUser != null){
        localStorage.setItem("userDetail",JSON.stringify(this.user));
      }
      console.log("response :: "+response)
      //localStorage.setItem("loginToken", response.refreshToken)

    });
  }
    loadAppointMent(){
      const userDetail = localStorage.getItem("userDetail");
      if(userDetail!=null){
        console.log("user details: "+userDetail);
        const user = JSON.parse(userDetail);
          if(user.role=="PATIENT"){
            console.log("user id : "+user.id);
             this.http.get(`http://localhost:8080/api/v1/appointment/${user.id}`).subscribe((response:any)=>{
              console.log("responce user "+response)
              this.appointment =response;
             });
          }else if(user.role=="ADMIN"){
            this.http.get('http://localhost:8080/api/v1/appointment/all-appointments').subscribe((response:any)=>{
              console.log("responce user "+response)
              this.appointment =response;
          
            });
          }
        }
    }
}
