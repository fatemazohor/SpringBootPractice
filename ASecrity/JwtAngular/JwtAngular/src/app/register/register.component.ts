import { Component } from '@angular/core';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  form:any={
    name:null,
    email:null,
    password:null,
    role:'ADMIN'
  }

  isSuccessful=false;
  isSignUpFaild=false;
  errorMessage=''; 

  constructor(private authService:AuthService){}

  onSubmit():void{

    const {name,email,password, role} =this.form;
    this.authService.register(name,email,password,role).subscribe({
      next: data=>{
        console.log(data);
        this.isSuccessful=true;
        this.isSignUpFaild=false;
      },
      error:err=>{
        this.errorMessage=err.error.errorMessage;
        this.isSignUpFaild=true;
      }

    })

  }



}
