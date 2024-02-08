import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class ErrorService {
  constructor(private router: Router) {}

  handleError(error: any): void {
    console.error('Manejo de error:', error);
    Swal.fire({
      icon: 'error',
      title: '¡Ocurrio un error!',
      text: 'Se produjo un error en el servidor. Por favor, inténtelo de nuevo más tarde.',
    }).then(() => {
      this.router.navigate(['']);
    });
  }
}
