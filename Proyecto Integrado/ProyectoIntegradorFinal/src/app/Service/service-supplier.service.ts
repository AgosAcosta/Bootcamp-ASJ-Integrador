import { Injectable } from '@angular/core';
import { Supplier } from '../Models/supplier';
import { Observable, of } from 'rxjs';
import { supplierData } from '../data/supplierData';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ServiceSupplierService {
  constructor(private http: HttpClient) {}

  supplierList: Supplier[] = supplierData;

  private URL = 'http://localhost:8080/supplier';

  public getListSupplier(): Observable<any> {
    return this.http.get(this.URL);
  }

  public getSuppliertById(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}`);
  }

  public postSupplier(supplier: Supplier): Observable<any> {
    return this.http.post<any>(this.URL, supplier);
  }

  public updateSupplier(id: number, supplier: Supplier): Observable<any> {
    return this.http.put<any>(`${this.URL}/${id}`, supplier);
  }



  

  addSupplier(newsupplier: Supplier) {
    this.supplierList.push(newsupplier);

    console.log('Agregando proveedor:', newsupplier);
  }

  deleteSupplier(id: number) {
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

  /*   public updateSupplier(newsupplier: Supplier) {
    let update = this.supplierList.find(
      (item) => item.idSupplier == newsupplier.idSupplier
    );
    update = newsupplier;
  } */

  public doesSupplierExist(id: number): boolean {
    return this.supplierList.some((supplier) => supplier.idSupplier === id);
  }
}
