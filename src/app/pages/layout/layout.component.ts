import { Component } from '@angular/core';
import { RouterOutlet,Router } from '@angular/router';
import { CurrentUser } from '../../class/User';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [RouterOutlet,CommonModule],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css'
})
export class LayoutComponent {
  user:CurrentUser
  constructor(private router:Router){
    this.user = new CurrentUser();
    this.getUserDetail();
  }
  onLogout(){
    localStorage.removeItem('loginToken');
    localStorage.removeItem('userDetail');
    this.router.navigateByUrl("/login");
  }
  getUserDetail(){
    const userDetail = localStorage.getItem("userDetail");
    if(userDetail!=null){
      this.user = JSON.parse(userDetail);
    }
    console.log(this.user);
    
  }
}
