import { Component, OnInit } from '@angular/core';
import { PurchaseOrder } from '../../../../Models/purchaseOrder';
import { ServicePurchaseOrderService } from '../../../../Service/service-purchase-order.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-purchase-order',
  templateUrl: './details-purchase-order.component.html',
  styleUrl: './details-purchase-order.component.css',
})
export class DetailsPurchaseOrderComponent implements OnInit {
  purchaseOrder!: PurchaseOrder | undefined;
  purchaseOrderId: number = -1;

  constructor(
    public servicePucharseOrder: ServicePurchaseOrderService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      let id = params['id'];
      if (id != undefined) {
        this.purchaseOrder = this.servicePucharseOrder.getIdPurchaseOrder(id)!;
      }
    });
  }
}
