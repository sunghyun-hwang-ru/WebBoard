import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './component/user/auth/auth.component';
import { RegistComponent } from './component/user/regist/regist.component';
import { ForgotComponent } from './component/user/forgot/forgot.component';

const routes: Routes = [
  {path: 'user/auth', component: AuthComponent},
  {path: 'user/regist', component: RegistComponent},
  {path: 'user/forgot', component: ForgotComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
