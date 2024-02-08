import { Injectable } from '@angular/core';
import { PurchaseOrder } from '../Models/purchaseOrder';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ErrorService } from './error.service';

@Injectable({
  providedIn: 'root',
})
export class ServicePurchaseOrderService {
  purchaseOrderList: PurchaseOrder[] = [];

  constructor(private http: HttpClient, private errorService: ErrorService) {}

  private URL = 'http://localhost:8080/purchaseOrder';

  public getListPurchaseOrder(): Observable<any> {
    return this.http.get(this.URL).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public getListPurchaseOrderDelete(): Observable<any> {
    return this.http.get(`${this.URL}/deleteTrue`).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public postPurchaseOrder(purchaseOrder: PurchaseOrder): Observable<any> {
    return this.http.post(this.URL, purchaseOrder).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public getPurchaseOrderById(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}`).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public updatePurchaseOrder(
    id: number,
    order: PurchaseOrder
  ): Observable<any> {
    return this.http.put(`${this.URL}/${id}`, order).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public cancelledPurchaseOrder(id: number): Observable<any> {
    return this.http.patch<any>(`${this.URL}/delete/${id}`, {}).pipe(
      catchError((error) => {
        this.errorService.handleError(error);
        throw error;
      })
    );
  }

  public countActivePurchaseOrder(): Observable<any> {
    return this.http.get(`${this.URL}/active/count`);
  }

  public countDeletedPurchaseOrder(): Observable<any> {
    return this.http.get(`${this.URL}/deleted/count`);
  }
}
