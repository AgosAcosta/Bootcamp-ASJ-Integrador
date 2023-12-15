import { Component } from '@angular/core';

@Component({
  selector: 'app-listado-productos',
  templateUrl: './listado-productos.component.html',
  styleUrl: './listado-productos.component.css'
})
export class ListadoProductosComponent {
  formulario: any [] = [
    {
      nombre: 'Producto 1',
      categoria: 'Alimenticio',
      descripcion: 'Producto 1 color bla bla',
      precio: '$1.200'
    },
    {
      nombre: 'Producto 2',
      categoria: 'Tecnologico',
      descripcion: 'Producto 2 color bla bla',
      precio: '$5.200'
    },
    {
      nombre: 'Producto 3',
      categoria: 'Insumos',
      descripcion: 'Producto 3 color bla bla',
      precio: '$8.200'
    },
  ]

}
