import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CategoryProductService {
  constructor(private http: HttpClient) {}

  private URL = 'http://localhost:8080/categoryProduct';

  public getListCategoryProduct() {
    return this.http.get(this.URL);
  }
}
