import {Component, OnInit} from '@angular/core';
import {SigninService} from "../signin.service";
import {User} from "../user";
import {Router} from "@angular/router";
import {UsersService} from "../users.service";
import {JwtToken} from "../jwt-token";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit{
  public users: User[] | undefined;
  // @ts-ignore
  public user: User;
  authenticating = false;
  loginFailed = false;

  constructor(private signinService: SigninService, private router: Router, private usersService: UsersService) {
  }

  ngOnInit() {
    this.user = new User();
  }

  signin() {
    this.authenticating = true;
    this.loginFailed = false;
    this.signinService.signIn(this.user).subscribe(
      (jwtToken: JwtToken) => this.successfulLogin(jwtToken),
      () => this.loginFailed = true
    ).add(() => this.authenticating = false);
  }

  successfulLogin(jwtToken: JwtToken){
    localStorage.setItem('token', jwtToken.refreshToken);
    this.usersService.getCurrentUser().subscribe((currentUser:User) => this.usersService.currentUser = currentUser);
    this.router.navigate(['/']);
  }
}
