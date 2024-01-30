import { Injectable } from '@angular/core';
import { Product } from '../Models/product';
import { Supplier } from '../Models/supplier';
import { productData } from '../data/productData';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServiceProductService {
  productList: Product[] = [];
  //Para buscar el nombre del proveedor
  supplierList: Supplier[] = [];

  constructor(private http: HttpClient) {
    this.productList = [...productData];
  }

  private URL = 'http://localhost:8080/product';

  public getListProducts(): Observable<any> {
    return this.http.get(this.URL);
  }

  public getProductById(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}`);
  }

  public postProduct(product: Product): Observable<any> {
    return this.http.post<any>(this.URL, product);
  }

  public updateProduct(id: number, product: Product): Observable<any> {
    return this.http.put<any>(`${this.URL}/${id}`, product);
  }

  public getProductsBySupplierId(supplierId: number): Observable<any> {
    return this.http.get<any>(`${this.URL}/${supplierId}/supplier`);
  }

  // ------------------------ ANTES DE BACK

  deleteProduct(id: number) {
    const index = this.productList.findIndex((item) => item.idProduct === id);
    if (index !== -1) {
      this.productList.splice(index, 1);
    }
  }

  public getIdProduct(id: any): Product | undefined {
    return this.productList.find((item) => item.idProduct == id);
  }

  public getProductByName(productName: string): Product | undefined {
    return this.productList.find(
      (product) => product.nameProduct === productName
    );
  }

  getProductsBySupplier(supplier: string): Product[] {
    return this.productList.filter(
      (product) => product.supplierName === supplier
    );
  }

  public doesProductExist(id: Number): boolean {
    return this.productList.some((product) => product.idProduct === id);
  }
}
