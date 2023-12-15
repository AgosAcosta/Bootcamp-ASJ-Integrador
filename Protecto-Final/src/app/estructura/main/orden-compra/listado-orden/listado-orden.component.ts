import { Component } from '@angular/core';

@Component({
  selector: 'app-listado-orden',
  templateUrl: './listado-orden.component.html',
  styleUrl: './listado-orden.component.css',
})
export class ListadoOrdenComponent {
  formulario: any[] = [
    {
      nOrden: '1',
      fechaEmision: '15/12/2023',
      fechaEntrega: '17/12/2023',
      direccion: 'Calle inventada n° 1234',
      total: '$120.000',
    },
    {
      nOrden: '2',
      fechaEmision: '15/12/2023',
      fechaEntrega: '28/12/2023',
      direccion: 'Calle inventada n° 1234',
      total: '$1.200.000',
    },
    {
      nOrden: '3',
      fechaEmision: '15/12/2023',
      fechaEntrega: '19/12/2023',
      direccion: 'Calle inventada n° 1234',
      total: '$50.000',
    },
  ];
}
