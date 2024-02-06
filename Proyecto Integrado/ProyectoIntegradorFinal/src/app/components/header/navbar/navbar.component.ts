import { Component } from '@angular/core';
import { LoginService } from '../../../Service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  constructor(private loginService: LoginService, private router: Router) {}

  loginOut() {
    this.loginService.setLoggedIn(false);
    this.loginService.setLogin(false);

    console.log('Cerrando sesion');
    this.router.navigate(['/login']);
  }
}
