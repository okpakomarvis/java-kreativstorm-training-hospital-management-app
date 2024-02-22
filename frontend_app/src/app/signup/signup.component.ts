import { Component } from '@angular/core';
import {User} from "../user";
import {SigninService} from "../signin.service";
import {SignUpRequest} from "../sign-up-request";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  constructor(private signinService: SigninService) {
  }

  signup(email: string, password: string, title: string, name: string, info: string) {
    email = email.trim();
    password = password.trim();
    title = title.trim();
    name = name.trim();
    info = info.trim();
    if(!email || !password || !title || !name || !info){
      return;
    }
    this.signinService.signUp({email, password, title, name, info} as SignUpRequest);
  }

}
