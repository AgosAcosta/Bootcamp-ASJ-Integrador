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
    this.servicePurchaseOrder.getListPurchaseOrder().subscribe(
      (data: PurchaseOrder[]) => {
        console.log('Obteniendo orden de compra', data);
        this.purchaseOrderList = data;
      },
      (error) => {
        console.error('Error al obtener orden de compra:', error);
      }
    );
  }

  statusPucharseOrder(id: any) {
    let msj = confirm('Desea cancelar la orden de compra?');
    if (msj) {
      const updatedOrder = this.servicePurchaseOrder
        .cancelledPurchaseOrder(id)
        .subscribe((data) => {
          console.log('CAMBIANDO ESTADO', data);
          this.listPurchaseOrder();
        });
      if (updatedOrder) {
        this.listPurchaseOrder();
      }
    }
  }
}
