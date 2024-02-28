import {Authority} from "./authority";

export class User {
  email: string;
  password: string;
  authorities: Authority[];

  constructor()
  {
    this.email = "";
    this.password = "";
    this.authorities = [];
  }



}
