import { Injectable } from '@angular/core';
import { ordenCompra } from '../data/ordenCompra';

@Injectable({
  providedIn: 'root'
})
export class ServiceOrdenCompraService {

  constructor() {}

  ordenCompraList: any = ordenCompra;
 
  agregarOrdenCompra(newOrdenCompra: any) {
     this.ordenCompraList.push(newOrdenCompra);
     console.log(this.ordenCompraList);
   }
 
   getOrdenCompra() {
     return this.ordenCompraList;
   }
}
