import { Component } from '@angular/core';
import { ServiceProductoService } from '../../../../Service/service-producto.service';

@Component({
  selector: 'app-alta-productos',
  templateUrl: './alta-productos.component.html',
  styleUrl: './alta-productos.component.css',
})
export class AltaProductosComponent {
  id: number = 0;
  categoria: string = '';
  nombre: string = '';
  descripcion: string = '';
  precio: string = '';

  newProducto: any = {};

  constructor(private productosService: ServiceProductoService) {}

  agregarProducto() {
    this.newProducto = {
      id: this.id,
      categoria: this.categoria,
      nombre: this.nombre,
      descripcion: this.descripcion,
      precio: this.precio,
    };

    this.productosService.agregarProductos(this.newProducto);
    this.newProducto = {};
  }
}
