import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PurchaseOrder } from '../../../../Models/purchaseOrder';
import { ServicePurchaseOrderService } from '../../../../Service/service-purchase-order.service';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import { ServiceProductService } from '../../../../Service/service-product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderDetail } from '../../../../Models/purchaseOrderDetail';

@Component({
  selector: 'app-form-purchase-order',
  templateUrl: './form-purchase-order.component.html',
  styleUrl: './form-purchase-order.component.css',
})
export class FormPurchaseOrderComponent implements OnInit {
  newPurchaseOrder: PurchaseOrder = {
    idPurchaseOrder: '',
    dateIssue: new Date(),
    dateDelivery: new Date(),
    recepcion: '',
    orderDetails: [],
    total: 0,
    status: 'Activa',
  };

  idPurchaseOrden: string = '';
  isUpdate: boolean = false;
  supplierName: string[] = [];
  msj: boolean = false;

  /*   productName: string[] = []; */

  constructor(
    public servicePurchaseOrder: ServicePurchaseOrderService,
    private serviceSupplier: ServiceSupplierService,
    public serviceProduct: ServiceProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((response) => {
      let id = response.get('id');
      if (id != undefined) {
        this.newPurchaseOrder =
          this.servicePurchaseOrder.getIdPurchaseOrder(id)!;
        this.isUpdate = true;
      }
    });

    this.supplierName = this.serviceSupplier
      .getListSupplier()
      .map((supplierName) => supplierName.nameSupplier);
  }

  onSupplierChange(supplier: any) {
    if (supplier) {
      this.loadProductsForSupplier(supplier);
    } /* else {
      console.error('Error en proveedor');
      this.productName = [];
    } */
  }

  loadProductsForSupplier(supplier: any) {
    console.log('Proveedor seleccionado:', supplier);

    if (supplier) {
      supplier.products = this.serviceProduct
        .getProductsBySupplier(supplier.name)
        .map((product) => product.nameProduct);
      console.log('Productos del proveedor:', supplier.products);
    }
  }

  createNewPuchseOrder(form: NgForm) {
    if (!form.valid) {
      console.log('Revisar los datos ingresados');
      return;
    }
    if (this.isUpdate) {
      this.servicePurchaseOrder.updatePurchaseOrder(this.newPurchaseOrder);
      console.log('Actualizando orden:', form.value);
      this.msj = true;
      setTimeout(() => {
        this.router.navigate(['/list-purchase-order']);
      }, 1500);
    } else {
      this.servicePurchaseOrder.addPurchaseOrder(this.newPurchaseOrder);
      console.log('Creando Nueva orden:', form.value);
      this.msj = true;
      setTimeout(() => {
        this.router.navigate(['/list-purchase-order']);
      }, 1500);
    }
  }

  calculateTotal() {
    this.newPurchaseOrder.orderDetails.forEach((detail) => {
      const selectedProduct = this.serviceProduct
        .getListProduct()
        .find((product) => product.nameProduct === detail.product);

      if (selectedProduct) {
        detail.total = selectedProduct.priceProduct * detail.unitProduct;
      }
    });
    this.newPurchaseOrder.total = this.newPurchaseOrder.orderDetails.reduce(
      (total, detail) => total + detail.total,
      0
    );
  }

  addOrderDetail() {
    const newDetail: OrderDetail = {
      product: '',
      unitProduct: 0,
      total: 0,
      supplier: {
        name: '',
        products: [],
      },
    };
    this.newPurchaseOrder.orderDetails.push(newDetail);
  }

  ClearForm() {
    this.newPurchaseOrder = {
      idPurchaseOrder: '',
      dateIssue: new Date(),
      dateDelivery: new Date(),
      recepcion: '',
      orderDetails: [],
      total: 0,
      status: 'Activa',
    };

    this.msj = false;
  }
}
