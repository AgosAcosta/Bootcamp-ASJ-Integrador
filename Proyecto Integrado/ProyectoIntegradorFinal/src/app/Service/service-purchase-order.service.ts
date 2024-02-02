import { Injectable } from '@angular/core';
import { PurchaseOrder } from '../Models/purchaseOrder';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServicePurchaseOrderService {
  purchaseOrderList: PurchaseOrder[] = [];

  constructor(private http: HttpClient) {}

  private URL = 'http://localhost:8080/purchaseOrder';

  public getListPurchaseOrder(): Observable<any> {
    return this.http.get(this.URL);
  }

  public getListPurchaseOrderDelete(): Observable<any> {
    return this.http.get(`${this.URL}/deleteTrue`);
  }

  public postPurchaseOrder(purchaseOrder: PurchaseOrder): Observable<any> {
    return this.http.post(this.URL, purchaseOrder);
  }

  public getPurchaseOrderById(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}`);
  }

  public updatePurchaseOrder(
    id: number,
    order: PurchaseOrder
  ): Observable<any> {
    return this.http.put(`${this.URL}/${id}`, order);
  }

  public cancelledPurchaseOrder(id: number): Observable<any> {
    return this.http.patch<any>(`${this.URL}/delete/${id}`, {});
  }
}
