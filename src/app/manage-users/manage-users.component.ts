import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CurrentUser } from '../class/User';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-manage-users',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './manage-users.component.html',
  styleUrl: './manage-users.component.css'
})
export class ManageUsersComponent {
  users: CurrentUser[] =[];
  constructor(private http:HttpClient){
    this.loadUsers();
  }

  loadUsers(){
      const userDetail = localStorage.getItem("userDetail");
      if(userDetail!=null){
        console.log("user details: "+userDetail);
        const user = JSON.parse(userDetail);
          console.log("user from localhost: "+user.role);
          if(user.role=="ADMIN"){
             this.http.get('http://localhost:8080/api/v1/user/all').subscribe((response:any)=>{
              console.log("responce user from admin "+response)
              this.users =response;
             });
           }
          }
        }
    
}
