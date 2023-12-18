import { Injectable } from '@angular/core';
import { proveedor } from '../data/proveedores';

@Injectable({
  providedIn: 'root',
})
export class ServiceProveedoresService {
  constructor() {}

 proveedoresList: any = proveedor;

  agregarProveedor(nuevoProveedor: any) {
    this.proveedoresList.push(nuevoProveedor);
    console.log(this.proveedoresList);
  }

  getPrueba() {
    return this.proveedoresList;
  }
}
