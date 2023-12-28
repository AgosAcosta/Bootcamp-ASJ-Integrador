import { Injectable } from '@angular/core';
import { Supplier } from '../Models/supplier';
import { Observable, of } from 'rxjs';
import { supplierData } from '../data/supplierData';

@Injectable({
  providedIn: 'root',
})
export class ServiceSupplierService {
  constructor() {}

  supplierList: Supplier[] = supplierData;

  getListSupplier() {
    return this.supplierList;
  }

  addSupplier(newsupplier: Supplier) {
    this.supplierList.push(newsupplier);

    console.log('Agregando proveedor:', newsupplier);
  }

  deleteSupplier(id: string) {
    const index = this.supplierList.findIndex((item) => item.idSupplier === id);
    if (index !== -1) {
      this.supplierList.splice(index, 1);
    }
  }

  public getIdSupplier(id: any): Supplier {
    const prove = this.supplierList.filter((item) => item.idSupplier == id)[0];
    console.log('prove', prove);
    return prove;
  }

  public updateSupplier(newsupplier: Supplier) {
    let update = this.supplierList.find(
      (item) => item.idSupplier == newsupplier.idSupplier
    );
    update = newsupplier;
  }

  public doesSupplierExist(id: string): boolean {
    return this.supplierList.some((supplier) => supplier.idSupplier === id);
  }
}
