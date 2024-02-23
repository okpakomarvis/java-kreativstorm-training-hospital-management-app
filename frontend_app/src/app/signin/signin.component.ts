import { Component } from '@angular/core';
import {SigninService} from "../signin.service";
import {User} from "../user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {
  public users: User[] | undefined;

  constructor(private signinService: SigninService, private router: Router) {
  }

  signin(email: string, password: string) {
    email = email.trim();
    password = password.trim();
    if(!email || !password){
      return;
    }
    this.signinService.signIn({email, password} as User).subscribe((res: any) => {
      console.log('User signed in successfully');
      localStorage.setItem('token', JSON.stringify(res.refreshToken));
      this.router.navigateByUrl('/');
    });
  }
}
