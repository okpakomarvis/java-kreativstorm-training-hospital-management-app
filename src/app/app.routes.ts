import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LayoutComponent } from './pages/layout/layout.component';
import { SignupComponent } from './pages/signup/signup.component';
import { ManageUsersComponent } from './manage-users/manage-users.component';
import { ProfileComponent } from './profile/profile.component';

export const routes: Routes = [
    {path:'register',component:SignupComponent},
    {path:'login',component:LoginComponent},
    {path:'', redirectTo:'login', pathMatch:'full'},
    {path:'', component:LayoutComponent, children:[
        {path:'dashboard', component:DashboardComponent},
        {path:'manageuser', component:ManageUsersComponent},
        {path:'profile', component:ProfileComponent}
    ]},
    {path:'**', component:LoginComponent}
];
