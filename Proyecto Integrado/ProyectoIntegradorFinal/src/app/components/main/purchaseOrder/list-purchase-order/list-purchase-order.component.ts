import { Component, OnInit } from '@angular/core';
import { PurchaseOrder } from '../../../../Models/purchaseOrder';
import { ServicePurchaseOrderService } from '../../../../Service/service-purchase-order.service';

@Component({
  selector: 'app-list-purchase-order',
  templateUrl: './list-purchase-order.component.html',
  styleUrl: './list-purchase-order.component.css',
})
export class ListPurchaseOrderComponent implements OnInit {
  purchaseOrderList!: PurchaseOrder[];

  constructor(public servicePurchaseOrder: ServicePurchaseOrderService) {}

  ngOnInit(): void {
    this.listPurchaseOrder();
  }

  listPurchaseOrder() {
    this.purchaseOrderList = this.servicePurchaseOrder.getListPurchaseOrder();
    console.log('Para ver estado:', this.purchaseOrderList);
  }

  statusPucharseOrder(id: any) {
    let msj = confirm('Desea cancelar la orden de compra?');
    if (msj) {
      const newStatus = 'Cancelado';
      const updatedOrder = this.servicePurchaseOrder.changeStatus(
        id,
        newStatus
      );

      if (updatedOrder) {
        this.listPurchaseOrder();
      }
    }
  }
}
