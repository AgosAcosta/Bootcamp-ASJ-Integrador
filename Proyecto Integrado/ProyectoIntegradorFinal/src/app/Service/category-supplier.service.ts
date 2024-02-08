import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategorySupplier } from '../Models/supplier';
import { catchError } from 'rxjs/operators';
import { ErrorService } from './error.service';

@Injectable({
  providedIn: 'root',
})
export class CategorySupplierService {
  
  constructor(private http: HttpClient, private errorService: ErrorService) {}

  private URL = 'http://localhost:8080/categorySupplier';

  public getCategoriesSupplier(): Observable<any> {
    return this.http.get(this.URL).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }
  public getCategoriesSupplierById(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}`).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }
  public postCategoriesSupplier(category: CategorySupplier): Observable<any> {
    return this.http.post(this.URL, category).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public putCategoriesSupplier(
    id: number,
    category: CategorySupplier
  ): Observable<any> {
    return this.http.put(`${this.URL}/${id}`, category).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public deleteCategoriesSupplier(id: number): Observable<any> {
    return this.http.patch<any>(`${this.URL}/delete/${id}`, {}).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public existsNameCategory(nameCategory: string): Observable<boolean> {
    return this.http.patch<boolean>(
      `${this.URL}/exists/name/${nameCategory}`,
      null
    ).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }
}
