import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LogLayoutComponent } from './component/log-layout/log-layout.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { MainLayoutComponent } from './component/main-layout/main-layout.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';

const routes: Routes = [
  {
    path: '', component: LogLayoutComponent,
    children: [
      { path: '', component: LoginComponent },
      { path: 'register', component: RegisterComponent }
    ]
  },
  {
    path: 'home', component: MainLayoutComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent },
    ]
  },
  {path:'**',redirectTo:'',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
