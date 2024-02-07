import { Component, OnInit } from '@angular/core';
import { ServiceSupplierService } from '../../../Service/service-supplier.service';
import { ServiceProductService } from '../../../Service/service-product.service';
import { ServicePurchaseOrderService } from '../../../Service/service-purchase-order.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css',
})
export class MenuComponent implements OnInit {
  constructor(
    private supplierService: ServiceSupplierService,
    private productService: ServiceProductService,
    private purchaseOrderService: ServicePurchaseOrderService
  ) {}

  countActiveSupplier: number = 0;
  countDeletedSupplier: number = 0;

  countActiveProduct: number = 0;
  countDeletedProduct: number = 0;

  countActivePurchaseOrder: number = 0;
  countDeletedPurchaseOrder: number = 0;

  ngOnInit(): void {
    this.countSupplier();
    this.countProduct();
    this.countPurchaseOrder();
  }

  countSupplier() {
    this.supplierService.countActiveSupplier().subscribe((data) => {
      this.countActiveSupplier = data;
    });

    this.supplierService.countDeletedSupplier().subscribe((data) => {
      this.countDeletedSupplier = data;
    });
  }

  countProduct() {
    this.productService.countActiveProducts().subscribe((data) => {
      this.countActiveProduct = data;
    });

    this.productService.countDeletedProducts().subscribe((data) => {
      this.countDeletedProduct = data;
    });
  }

  countPurchaseOrder() {
    this.purchaseOrderService.countActivePurchaseOrder().subscribe((data) => {
      this.countActivePurchaseOrder = data;
    });

    this.purchaseOrderService.countDeletedPurchaseOrder().subscribe((data) => {
      this.countDeletedPurchaseOrder = data;
    });
  }
}
