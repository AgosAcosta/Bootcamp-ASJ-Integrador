import { Injectable } from '@angular/core';
import { Supplier } from '../data/proveedores';

@Injectable({
  providedIn: 'root',
})
export class ServiceProveedoresService {
  constructor() {}

  // proveedoresList: any = proveedor;
  supplierList: Supplier[] = [];

  //! Obtener lista de los proveedores:

  getListSupplier() {
    return this.supplierList;
  }

  //! Agregar proveedor:

  addSupplier(newsupplier: Supplier) {
    this.supplierList.push(newsupplier);

    console.log('Agregando proveedor:', newsupplier);
  }

  //! Eliminar proveedor:

  deleteSupplier(id: number) {
    const index = this.supplierList.findIndex((item) => item.idSupplier === id);
    if (index !== -1) {
      this.supplierList.splice(index, 1);
    }
  }

/*   getSupplierById(id: number): Supplier | null {
    return this.supplierList.find((item) => item.idSupplier === id) || null;
  } */
}
