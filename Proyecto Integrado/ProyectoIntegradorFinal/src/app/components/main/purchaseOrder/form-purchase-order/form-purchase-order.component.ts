import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PurchaseOrder } from '../../../../Models/purchaseOrder';
import { ServicePurchaseOrderService } from '../../../../Service/service-purchase-order.service';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import { ServiceProductService } from '../../../../Service/service-product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DetailProducts } from '../../../../Models/purchaseOrder';
import { Supplier } from '../../../../Models/supplier';
import { DatePipe } from '@angular/common';

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
    supplier: '',
    products: [],
    total: 0,
    status: 'Activa',
  };

  detailProducts: DetailProducts = {
    idProduct: '',
    nameProduct: '',
    priceProduct: 0,
    unitProduct: 0,
  };

  idPurchaseOrden: string = '';
  isUpdate: boolean = false;
  supplierName: string[] = [];
  msj: boolean = false;
  allProducts: any[] = [];

  supplierPoin = true;

  date = new Date();
  msjId: boolean = false;

  constructor(
    public servicePurchaseOrder: ServicePurchaseOrderService,
    private serviceSupplier: ServiceSupplierService,
    public serviceProduct: ServiceProductService,
    private route: ActivatedRoute,
    private router: Router,
    private datePipe: DatePipe
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

    /*     this.allProducts = this.newPurchaseOrder.products.map((product) => ({
      nameProduct: product.nameProduct,
      priceProduct: product.priceProduct,
      idProduct: product.idProduct,
      unitProduct: product.unitProduct,
    })); */

    this.supplierName = this.serviceSupplier
      .getListSupplier()
      .map((supplier) => supplier.nameSupplier);
  }

  changeSupplier(supplier: any) {
    if (supplier) {
      console.log('Proveedor seleccionado:', supplier);

      const productsBySupplier =
        this.serviceProduct.getProductsBySupplier(supplier);
      this.allProducts = productsBySupplier.map((product) => ({
        nameProduct: product.nameProduct,
        priceProduct: product.priceProduct,
        idProduct: product.idProduct,
        unitProduct: 1,
      }));

      console.log('Probando produ', this.allProducts);
    } else console.log('Ningún proveedor seleccionado');
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
      if (
        this.servicePurchaseOrder.doesPurchaseOrderExist(
          this.newPurchaseOrder.idPurchaseOrder
        )
      ) {
        console.log('ya existe el proveedor');
        this.msjId = true;
        setTimeout(() => {
          this.newPurchaseOrder.idPurchaseOrder = '';
          this.msjId = false;
        }, 1500);
        return;
      }

      this.servicePurchaseOrder.addPurchaseOrder(this.newPurchaseOrder);
      console.log('Creando Nueva orden:', form.value);
      this.msj = true;
      setTimeout(() => {
        this.router.navigate(['/list-purchase-order']);
      }, 1500);
    }
  }

  calculateTotal() {
    this.newPurchaseOrder.total = 0;
    for (const product of this.newPurchaseOrder.products) {
      this.newPurchaseOrder.total += product.priceProduct * product.unitProduct;
    }
  }

  addOrderDetail() {
    const productSelected = this.allProducts.find(
      (products) => products.nameProduct == this.detailProducts.nameProduct
    );

    if (productSelected) {
      this.detailProducts.priceProduct = productSelected.priceProduct;
      this.detailProducts.idProduct = productSelected.idProduct;
      if (this.detailProducts.unitProduct > 0) {
        const existingProduct = this.newPurchaseOrder.products.find(
          (product) => product.idProduct === this.detailProducts.idProduct
        );
        if (existingProduct) {
          existingProduct.unitProduct += this.detailProducts.unitProduct;
        } else {
          const newProductDetail: DetailProducts = {
            idProduct: this.detailProducts.idProduct,
            nameProduct: this.detailProducts.nameProduct,
            priceProduct: this.detailProducts.priceProduct,
            unitProduct: this.detailProducts.unitProduct,
          };

          this.newPurchaseOrder.products.push(newProductDetail);
        }

        this.calculateTotal();
        this.supplierPoin = false;
      }
    }
  }

  ClearForm() {
    this.newPurchaseOrder = {
      idPurchaseOrder: '',
      dateIssue: new Date(),
      dateDelivery: new Date(),
      recepcion: '',
      supplier: '',
      products: [],
      total: 0,
      status: 'Activa',
    };

    this.detailProducts = {
      idProduct: '',
      nameProduct: '',
      priceProduct: 0,
      unitProduct: 0,
    };
    this.msj = false;
    this.supplierPoin = true;
  }

  getMinDateShippingTemplate(): string {
    let dateShipping = this.getMinDateShipping();
    return this.datePipe.transform(dateShipping, 'yyyy-MM-dd') || '2024-01-01';
  }

  getMinDateShipping(): Date {
    const day = 1000 * 60 * 60 * 24;
    let daysDelay = 2;
    let dateCreated = this.getDateObject(this.newPurchaseOrder.dateIssue);
    return new Date(day * daysDelay + dateCreated.getTime());
  }

  getDateObject(date: string | Date): Date {
    let dateCreatedArray =
      this.datePipe.transform(date, 'yyyy&MM&dd')?.split('&') || '';
    return new Date(
      +dateCreatedArray[0],
      +dateCreatedArray[1] - 1,
      +dateCreatedArray[2]
    );
  }
}
