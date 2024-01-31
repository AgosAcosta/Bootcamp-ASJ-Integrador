import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoryProduct } from '../Models/product';

@Injectable({
  providedIn: 'root',
})
export class CategoryProductService {
  constructor(private http: HttpClient) {}

  private URL = 'http://localhost:8080/categoryProduct';

  public getListCategoryProduct(): Observable<any> {
    return this.http.get(this.URL);
  }

  public getCategoriesProductById(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}`);
  }
  public postCategoriesProduct(category: CategoryProduct): Observable<any> {
    return this.http.post(this.URL, category);
  }

  public putCategoriesProduct(
    id: number,
    category: CategoryProduct
  ): Observable<any> {
    return this.http.put(`${this.URL}/${id}`, category);
  }

  public deleteCategoriesProduct(id: number): Observable<any> {
    return this.http.patch<any>(`${this.URL}/delete/${id}`, {});
  }
}
