import { Component } from '@angular/core';
import { RouterOutlet,Router } from '@angular/router';


@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css'
})
export class LayoutComponent {

  constructor(private router:Router){

  }
  onLogout(){
    localStorage.removeItem('loginToken');
    this.router.navigateByUrl("/login");
  }
}
