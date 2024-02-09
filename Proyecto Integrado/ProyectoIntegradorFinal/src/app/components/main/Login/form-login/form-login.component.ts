import { Component } from '@angular/core';
import { Login } from '../../../../Models/login';
import { LoginService } from '../../../../Service/login.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrl: './form-login.component.css',
})
export class FormLoginComponent {
  login: Login = {
    user: '',
    password: '',
  };

  constructor(private loginService: LoginService, private router: Router) {}

  loginForm() {
    this.loginService.checkLogin(this.login).subscribe({
      next: (result) => {
        if (result) {
 
          this.loginService.setLoggedIn(true);
          Swal.fire({
            title: 'Ingresando...',
            icon: 'success',
            position: 'center',
            toast: true,
            timer: 1000,
            showConfirmButton: false,
            width: '300px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          }).then(() => {
            this.loginService.setLogin(true);
            this.router.navigate(['']);
          });
        } else {
           this.loginService.setLoggedIn(false);
          this.loginService.setLogin(false);

          Swal.fire({
            title: 'Usuario o contraseña inválidos',
            icon: 'error',
            position: 'center',
            toast: true,
            timer: 3000,
            showConfirmButton: false,
            width: '300px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          });
        }
      },
      error: (error) => {
        console.error('Error al iniciar sesión:', error);
      },
    });
  }

  forgetPassword() {
    Swal.fire({
      title: 'Se ha enviado un correo con la contraseña temporal',
      icon: 'warning',
      position: 'center',
      toast: true,
      timer: 2000,
      showConfirmButton: false,
      width: '300px',
      customClass: {
        popup: 'custom-popup-class',
        title: 'custom-title-class',
      },
    });
  }
}
