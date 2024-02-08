import { Injectable } from '@angular/core';
import { Supplier } from '../Models/supplier';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ErrorService } from './error.service';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ServiceSupplierService {
  constructor(private http: HttpClient, private errorService: ErrorService) {}

  private URL = 'http://localhost:8080/supplier';

  public getListSupplier(): Observable<any> {
    return this.http.get(this.URL).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public getListSupplierDelete(): Observable<any> {
    return this.http.get(`${this.URL}/deleteTrue`).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public getSuppliertById(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}`).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public postSupplier(supplier: Supplier): Observable<any> {
    return this.http.post<any>(this.URL, supplier).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public updateSupplier(id: number, supplier: Supplier): Observable<any> {
    return this.http.put<any>(`${this.URL}/${id}`, supplier).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public deleteSupplier(id: number): Observable<any> {
    return this.http.patch<any>(`${this.URL}/delete/${id}`, {}).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public activeSupplier(id: number): Observable<any> {
    return this.http.patch<any>(`${this.URL}/active/${id}`, {}).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public existsCuit(cuit: string): Observable<boolean> {
    return this.http
      .patch<boolean>(`${this.URL}/exists/cuit/${cuit}`, null)
      .pipe(
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

  public countActiveSupplier(): Observable<any> {
    return this.http.get(`${this.URL}/active/count`);
  }

  public countDeletedSupplier(): Observable<any> {
    return this.http.get(`${this.URL}/deleted/count`);
  }
}
