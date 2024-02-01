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
import { Product } from '../../../../Models/product';

@Component({
  selector: 'app-form-purchase-order',
  templateUrl: './form-purchase-order.component.html',
  styleUrl: './form-purchase-order.component.css',
})
export class FormPurchaseOrderComponent implements OnInit {
  newPurchaseOrder: PurchaseOrder = {
    idPurchaseOrder: 0,
    dateIssue: new Date(),
    dateDelivery: new Date(),
    recepcion: '',
    supplier: '',
    products: [],
    total: 0,
    status: 'Pendiente',
  };

  detailProducts: DetailProducts = {
    idProduct: '',
    nameProduct: '',
    priceProduct: 0,
    unitProduct: 0,
  };

  selectedProduct: any;
  suppliers: any[] = [];
  products: any[] = [];

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
        this.servicePurchaseOrder.getPurchaseOrderById(Number(id)).subscribe(
          (order) => {
            this.newPurchaseOrder = order;
            this.newPurchaseOrder.dateIssue = this.datePipe.transform(
              order.dateIssue,
              'yyyy-MM-dd'
            )!;
            this.newPurchaseOrder.dateDelivery = this.datePipe.transform(
              order.dateDelivery,
              'yyyy-MM-dd'
            )!;
            this.onSupplierSelected(order.nameSupplier);
            this.onProductSelected();
            this.isUpdate = true;
          },
          (error) => {
            console.error('Error al obtener la orden de compra por ID:', error);
          }
        );
      }
    });
    this.getListSupplier();
  }

  getListSupplier() {
    this.serviceSupplier.getListSupplier().subscribe((data: Supplier[]) => {
      console.log('Proveedores:', data);
      this.suppliers = data.map((supplier: Supplier) => supplier.nameSupplier);
    });
  }

  onSupplierSelected(supplierName: string) {
    const selectedSupplier = this.suppliers.find((supplier) => supplier === supplierName);

    if (selectedSupplier) {
      this.serviceProduct
        .getProductsBySupplierName(selectedSupplier)
        .subscribe((data: Product[]) => {
          this.products = data.map((product: Product) => ({
            idProduct: product.idProduct,
            nameProduct: product.nameProduct,
            priceProduct: product.priceProduct,
          }));
          console.log('Productos del proveedor:', this.products);
        });
    }
  } 


  onProductSelected() {
    this.selectedProduct = this.products.find(
      (product) => product.nameProduct === this.detailProducts.nameProduct
    );
  }

  addOrderDetails() {
    console.log('PRODUCTOS :', this.detailProducts);

    const selectedProduct = this.products.find(
      (product) => product.nameProduct === this.detailProducts.nameProduct
    );

    if (selectedProduct) {
      const existDetail = this.newPurchaseOrder.products.find(
        (detail) => detail.idProduct === selectedProduct.idProduct
      );
      if (existDetail) {
        existDetail.unitProduct += Number(this.detailProducts.unitProduct);
      } else {
        const newDetail: DetailProducts = {
          idProduct: selectedProduct.idProduct,
          nameProduct: selectedProduct.nameProduct,
          priceProduct: selectedProduct.priceProduct,
          unitProduct: Number(this.detailProducts.unitProduct),
        };

        this.newPurchaseOrder.products.push(newDetail);
      }
      this.selectedProduct.priceProduct = '';
      this.supplierPoin = false;
      this.calculateTotal();
      console.log('PRODUCTOS DETALLE:', this.newPurchaseOrder.products);
    }
  }

  createNewPuchseOrder(form: NgForm) {
    if (!form.valid) {
      console.log('Revisar los datos ingresados');
      return;
    }
    if (this.isUpdate) {
      this.servicePurchaseOrder
        .updatePurchaseOrder(
          this.newPurchaseOrder.idPurchaseOrder,
          this.newPurchaseOrder
        )
        .subscribe((data) => {
          console.log('Actualizando orden:', data);
        });

      this.msj = true;
      setTimeout(() => {
        this.router.navigate(['/list-purchase-order']);
      }, 1500);
    } else {
      this.servicePurchaseOrder
        .postPurchaseOrder(this.newPurchaseOrder)
        .subscribe((data) => {
          console.log('CREANDO NUEVA ORDEN DE COMPRA', data);
        });

      this.msj = true;
      setTimeout(() => {
        this.router.navigate(['/list-purchase-order']);
      }, 1500);
    }
  }

  calculateTotal() {
    let total = 0;
    for (const product of this.newPurchaseOrder.products) {
      const price = product.priceProduct;
      const unit = product.unitProduct;
      total += price * unit;
    }
    console.log('Total:', total);
    this.newPurchaseOrder.total = total;
  }

  ClearForm() {
    this.newPurchaseOrder = {
      idPurchaseOrder: 0,
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

    this.selectedProduct.priceProduct;
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
