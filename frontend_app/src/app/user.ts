import {Authority} from "./authority";

export interface User {
  email: string;
  password: string;
  authorities: Authority[];
}
