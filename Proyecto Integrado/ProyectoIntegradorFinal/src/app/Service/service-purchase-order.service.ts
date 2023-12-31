import { Injectable, IterableDiffers } from '@angular/core';
import { PurchaseOrder } from '../Models/purchaseOrder';
import { Supplier } from '../Models/supplier';
import { Product } from '../Models/product';

@Injectable({
  providedIn: 'root',
})
export class ServicePurchaseOrderService {
  purchaseOrderList: PurchaseOrder[] = [];

  //Revisar si los uso:
  supplierList: Supplier[] = [];
  productList: Product[] = [];

  //Varios productos Orden de compra:

  constructor() {}

  getListSupplier(): Supplier[] {
    return this.supplierList;
  }
  getListProduct() {
    return this.productList;
  }

  getListPurchaseOrder() {
    return this.purchaseOrderList;
  }

  addPurchaseOrder(newPurchaseOrder: PurchaseOrder) {
    this.purchaseOrderList.push(newPurchaseOrder);
    console.log('Agregando orden nueva:', newPurchaseOrder);
  }

  public getIdPurchaseOrder(id: any): PurchaseOrder | undefined {
    return this.purchaseOrderList.find((item) => item.idPurchaseOrder == id);
  }

  public updatePurchaseOrder(newPurchaseOrder: PurchaseOrder) {
    const updateIndex = this.purchaseOrderList.findIndex(
      (item) => item.idPurchaseOrder === newPurchaseOrder.idPurchaseOrder
    );

    if (updateIndex !== -1) {
      this.purchaseOrderList[updateIndex] = newPurchaseOrder;
    }
  }

  public changeStatus(
    id: string,
    newStatus: string
  ): PurchaseOrder | undefined {
    const orderToUpdate = this.purchaseOrderList.find(
      (item) => item.idPurchaseOrder === id
    );
    if (orderToUpdate) {
      orderToUpdate.status = newStatus;
    }
    return orderToUpdate;
  }

  public doesPurchaseOrderExist(id: string): boolean {
    return this.purchaseOrderList.some((order) => order.idPurchaseOrder === id);
  }
}
