import { Component, OnInit } from '@angular/core';
import { Router, RouterModule} from "@angular/router";
import { NavComponent } from "../nav/nav.component";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule }  from '@angular/common';
import { LoginService } from '../services/auth/login.service';
import { LoginRequest } from '../services/auth/loginRequest';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, NavComponent, ReactiveFormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  userLoginOn: boolean = false;


    constructor(private formBuilder: FormBuilder, private router:Router, private loginService: LoginService) { 
        this.loginForm = this.formBuilder.group({
        email:["jose@gmail.com", [Validators.required,Validators.email]],
        password:["", Validators.required],
      })
    }

    ngOnInit(): void {

    }

    get email(){
      return this.loginForm.controls['email'];
    }

    get password(){
      return this.loginForm.controls['password'];
    }

    login(){
      if (this.loginForm.valid){
        this.loginService.login(this.loginForm.value as LoginRequest);
        this.router.navigateByUrl("/inicio");
        this.loginForm.reset();
      }
      else  {
        this.loginForm.markAllAsTouched();
        alert ("Error al ingresar los datos.");
      }
    }

}