import { Component, OnInit } from '@angular/core';
import { PurchaseOrder } from '../../../../Models/purchaseOrder';
import { ServicePurchaseOrderService } from '../../../../Service/service-purchase-order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-purchase-order',
  templateUrl: './list-purchase-order.component.html',
  styleUrl: './list-purchase-order.component.css',
})
export class ListPurchaseOrderComponent implements OnInit {
  purchaseOrderList!: PurchaseOrder[];
  purchaseOrderActive: boolean = true;
  selectedStatus: boolean = true;

  constructor(public servicePurchaseOrder: ServicePurchaseOrderService) {}

  ngOnInit(): void {
    this.listPurchaseOrderActive();
  }

  onRadioChange(): void {
    if (this.selectedStatus) {
      this.listPurchaseOrderActive();
    } else {
      this.listPurchaseOrderDelete();
    }
  }

  listPurchaseOrderActive() {
    this.purchaseOrderActive = true;

    this.servicePurchaseOrder.getListPurchaseOrder().subscribe(
      (data: PurchaseOrder[]) => {
        this.purchaseOrderList = data;
      },
      (error) => {
        console.error('Error al obtener orden de compra:', error);
      }
    );
  }

  listPurchaseOrderDelete() {
    this.purchaseOrderActive = false;

    this.servicePurchaseOrder.getListPurchaseOrderDelete().subscribe(
      (data: PurchaseOrder[]) => {
        this.purchaseOrderList = data;
      },
      (error) => {
        console.error('Error al obtener orden de compra eliminadas', error);
      }
    );
  }

  statusPucharseOrder(id: any) {
    Swal.fire({
      title: 'Eliminar Producto',
      text: `¿Estás seguro de que deseas cancelar la orden de compra N° ${id}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, eliminarlo',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        const updatedOrder = this.servicePurchaseOrder
          .cancelledPurchaseOrder(id)
          .subscribe((data) => {
            this.listPurchaseOrderActive();
          });
      }
    });
  }
}
