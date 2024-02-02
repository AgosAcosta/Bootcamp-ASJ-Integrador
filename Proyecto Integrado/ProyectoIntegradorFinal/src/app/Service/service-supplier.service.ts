import { Injectable } from '@angular/core';
import { Supplier } from '../Models/supplier';
import { Observable} from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ServiceSupplierService {
  constructor(private http: HttpClient) {}

  private URL = 'http://localhost:8080/supplier';

  public getListSupplier(): Observable<any> {
    return this.http.get(this.URL);
  }

  public getListSupplierDelete(): Observable<any> {
    return this.http.get(`${this.URL}/deleteTrue`);
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

  public deleteSupplier(id: number): Observable<any> {
    return this.http.patch<any>(`${this.URL}/delete/${id}`, {});
  }

  public activeSupplier(id: number): Observable<any> {
    return this.http.patch<any>(`${this.URL}/active/${id}`, {});
  }

  public existsCuit(cuit: string): Observable<boolean> {
    return this.http.patch<boolean>(`${this.URL}/exists/cuit/${cuit}`, null);
  }

  public existsCode(code: string): Observable<boolean> {
    return this.http.patch<boolean>(`${this.URL}/exists/code/${code}`, null);
  }
}
