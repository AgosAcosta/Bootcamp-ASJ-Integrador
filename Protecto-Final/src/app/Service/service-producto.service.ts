import { Injectable } from '@angular/core';
import { productos } from '../data/productos';

@Injectable({
  providedIn: 'root'
})
export class ServiceProductoService {

  constructor() { }

  productosList: any = productos;

  agregarProductos(newProducto: any){
    this.productosList.push(newProducto);
    console.log(this.productosList);
  }

  getProductos(){
    return this.productosList;
  }
}
