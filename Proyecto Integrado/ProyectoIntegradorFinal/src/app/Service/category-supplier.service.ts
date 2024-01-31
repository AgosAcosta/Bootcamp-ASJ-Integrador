import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategorySupplier } from '../Models/supplier';

@Injectable({
  providedIn: 'root',
})
export class CategorySupplierService {
  constructor(private http: HttpClient) {}
  private url = 'http://localhost:8080/categorySupplier';

  public getCategoriesSupplier(): Observable<any> {
    return this.http.get(this.url);
  }
  public getCategoriesSupplierById(id: number): Observable<any> {
    return this.http.get(`${this.url}/${id}`);
  }
  public postCategoriesSupplier(category: CategorySupplier): Observable<any> {
    return this.http.post(this.url, category);
  }

  public putCategoriesSupplier(
    id: number,
    category: CategorySupplier
  ): Observable<any> {
    return this.http.put(`${this.url}/${id}`, category);
  }

  public deleteCategoriesSupplier(id: number): Observable<any> {
    return this.http.patch<any>(`${this.url}/delete/${id}`, {});
  }
}
