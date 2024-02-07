import { Component } from '@angular/core';
import { LoginService } from '../../../Service/login.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  constructor(private loginService: LoginService, private router: Router) {}

  loginOut() {
    this.loginService.setLoggedIn(false);

    Swal.fire({
      title: 'Cerrando sesión...',
      icon: 'info',
      position: 'center',
      toast: true,
      timer: 1500,
      showConfirmButton: false,
      width: '300px',
      customClass: {
        popup: 'custom-popup-class',
        title: 'custom-title-class',
      },
    }).then(() => {
      this.loginService.setLogin(false);

      console.log('Cerrando sesion');
      this.router.navigate(['/login']);
    });



  }
}

