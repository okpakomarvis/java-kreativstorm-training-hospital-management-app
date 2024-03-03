import { Component } from '@angular/core';
import { CurrentUser } from '../class/User';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  user:CurrentUser;
   constructor(private router:Router){
    this.user = new CurrentUser();
    this.getUserDetail();
  }

  getUserDetail(){
    const userDetail = localStorage.getItem("userDetail");
    if(userDetail!=null){
      this.user = JSON.parse(userDetail);
    }
    console.log("profile : "+this.user);
    
  }
}
