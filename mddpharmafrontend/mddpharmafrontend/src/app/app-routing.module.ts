import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './component/list/list.component';
import {LoginComponent} from './component/login/login.component';
import {LogoutComponent} from './component/logout/logout.component';

const routes: Routes = [
    {path: 'login', component: LoginComponent},
    {path: '', component: LoginComponent},
    {path: 'list', component: ListComponent},
   {path: 'logout', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
