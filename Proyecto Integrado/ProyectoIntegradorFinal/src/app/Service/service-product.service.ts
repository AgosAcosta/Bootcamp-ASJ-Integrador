import { Injectable } from '@angular/core';
import { Product } from '../Models/product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServiceProductService {
  productList: Product[] = [];
  constructor(private http: HttpClient) {}

  private URL = 'http://localhost:8080/product';

  public getListProducts(): Observable<any> {
    return this.http.get(this.URL);
  }

  public getListProductsDelete(): Observable<any> {
    return this.http.get(`${this.URL}/deleteTrue`);
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

  public deleteProduct(id: number): Observable<any> {
    return this.http.patch(`${this.URL}/delete/${id}`, {});
  }

  public activeProduct(id: number): Observable<any> {
    return this.http.patch(`${this.URL}/active/${id}`, {});
  }

  public existsCode(code: string): Observable<boolean> {
    return this.http.patch<boolean>(`${this.URL}/exists/code/${code}`, null);
  }

  public getProductsBySupplierName(supplierName: string): Observable<any> {
    return this.http.get<any>(`${this.URL}/${supplierName}/supplierName`);
  }

  public countActiveProducts(): Observable<any> {
    return this.http.get(`${this.URL}/active/count`);
  }

  public countDeletedProducts(): Observable<any> {
    return this.http.get(`${this.URL}/deleted/count`);
  }
}
