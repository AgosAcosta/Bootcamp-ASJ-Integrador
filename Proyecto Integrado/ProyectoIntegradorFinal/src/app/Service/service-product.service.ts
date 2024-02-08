import { Injectable } from '@angular/core';
import { Product } from '../Models/product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ErrorService } from './error.service';

@Injectable({
  providedIn: 'root',
})
export class ServiceProductService {
  productList: Product[] = [];
  constructor(private http: HttpClient, private errorService: ErrorService) {}

  private URL = 'http://localhost:8080/product';

  public getListProducts(): Observable<any> {
    return this.http.get(this.URL).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public getListProductsDelete(): Observable<any> {
    return this.http.get(`${this.URL}/deleteTrue`).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public getProductById(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}`).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public postProduct(product: Product): Observable<any> {
    return this.http.post<any>(this.URL, product).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public updateProduct(id: number, product: Product): Observable<any> {
    return this.http.put<any>(`${this.URL}/${id}`, product).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public getProductsBySupplierId(supplierId: number): Observable<any> {
    return this.http.get<any>(`${this.URL}/${supplierId}/supplier`).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public deleteProduct(id: number): Observable<any> {
    return this.http.patch(`${this.URL}/delete/${id}`, {}).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public activeProduct(id: number): Observable<any> {
    return this.http.patch(`${this.URL}/active/${id}`, {}).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public existsCode(code: string): Observable<boolean> {
    return this.http
      .patch<boolean>(`${this.URL}/exists/code/${code}`, null)
      .pipe(
        catchError((error) => {
          this.errorService.handleError(error);
          throw error;
        })
      );
  }

  public getProductsBySupplierName(supplierName: string): Observable<any> {
    return this.http.get<any>(`${this.URL}/${supplierName}/supplierName`).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public countActiveProducts(): Observable<any> {
    return this.http.get(`${this.URL}/active/count`);
  }

  public countDeletedProducts(): Observable<any> {
    return this.http.get(`${this.URL}/deleted/count`);
  }
}
