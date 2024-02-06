import { Component, OnInit } from '@angular/core';
import { LoginService } from './Service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  title = 'ProyectoIntegradorFinal';
  isLoggedIn = false;

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {
    this.loginService.isLogedIn$.subscribe((response) => {
      this.isLoggedIn = response;
    });
    this.isLoggedIn = this.loginService.isLoggedIn();
    if (!this.isLoggedIn) {
      this.router.navigate(['/login']);
    }
  }
}
