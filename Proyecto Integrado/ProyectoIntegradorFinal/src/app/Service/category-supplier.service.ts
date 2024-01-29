import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CategorySupplierService {
  constructor(private http: HttpClient) {}
  private url = 'http://localhost:8080/categorySupplier';

  public getCategoriesSupplier(): Observable<any> {
    return this.http.get(this.url);
  }
}
