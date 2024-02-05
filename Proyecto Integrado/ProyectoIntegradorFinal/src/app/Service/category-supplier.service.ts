import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategorySupplier } from '../Models/supplier';

@Injectable({
  providedIn: 'root',
})
export class CategorySupplierService {
  constructor(private http: HttpClient) {}
  private URL = 'http://localhost:8080/categorySupplier';

  public getCategoriesSupplier(): Observable<any> {
    return this.http.get(this.URL);
  }
  public getCategoriesSupplierById(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}`);
  }
  public postCategoriesSupplier(category: CategorySupplier): Observable<any> {
    return this.http.post(this.URL, category);
  }

  public putCategoriesSupplier(
    id: number,
    category: CategorySupplier
  ): Observable<any> {
    return this.http.put(`${this.URL}/${id}`, category);
  }

  public deleteCategoriesSupplier(id: number): Observable<any> {
    return this.http.patch<any>(`${this.URL}/delete/${id}`, {});
  }

  public existsNameCategory(nameCategory: string): Observable<boolean> {
    return this.http.patch<boolean>(
      `${this.URL}/exists/name/${nameCategory}`,
      null
    );
  }
}
