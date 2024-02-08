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
import Swal from 'sweetalert2';

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

  isUpdate: boolean = false;
  isSave: boolean = false;

  supplierPoin = true;
  supplierLogo: string = '';

  date = new Date();
  isDateInvalid: boolean = false;

  constructor(
    public servicePurchaseOrder: ServicePurchaseOrderService,
    private serviceSupplier: ServiceSupplierService,
    public serviceProduct: ServiceProductService,
    private route: ActivatedRoute,
    private router: Router,
    private datePipe: DatePipe
  ) {}

  ngOnInit(): void {
    this.getListSupplier();
    this.newPurchaseOrder.dateIssue = this.datePipe.transform(
      new Date(),
      'yyyy-MM-dd'
    )!;
  }

  getPurchaseOrderForUpdate() {
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

            this.onSupplierSelected(order.supplier);
            this.supplierPoin = false;
            this.onProductSelected();
            this.isUpdate = true;
          },
          (error) => {
            console.error('Error al obtener la orden de compra por ID:', error);
          }
        );
      }
    });
  }

  getListSupplier() {
    this.serviceSupplier.getListSupplier().subscribe((data: Supplier[]) => {
      console.log('Proveedores:', data);
      this.suppliers = data;
      this.getPurchaseOrderForUpdate(); //Esta funcion es porque necesita la lista de los proveedores para cargar el logo
    });
  }

  onSupplierSelected(supplierName: string) {
    console.log('supplierName', supplierName);
    const selectedSupplier = this.suppliers.find(
      (supplier) => supplier.nameSupplier === supplierName
    );
    console.log('SELECT', selectedSupplier);
    if (selectedSupplier) {
      this.serviceProduct
        .getProductsBySupplierName(selectedSupplier.nameSupplier)
        .subscribe((data: Product[]) => {
          this.products = data.map((product: Product) => ({
            idProduct: product.idProduct,
            nameProduct: product.nameProduct,
            priceProduct: product.priceProduct,
          }));
          console.log('Productos del proveedor:', this.products);
        });

      this.supplierLogo = selectedSupplier.urlLogo;
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
    this.isSave = true;
    this.validationDate();

    if (!form.valid || this.isDateInvalid) {
      console.log('Revisar los datos ingresados');
      Swal.fire({
        title: 'Error, revisar los campos obligatorios',
        icon: 'error',
        position: 'center',
        toast: true,
        timer: 1500,
        showConfirmButton: false,
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.isSave = false;
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

          Swal.fire({
            title: `Se actualizo con éxito la orden de compra N°: ${this.newPurchaseOrder.idPurchaseOrder}`,
            icon: 'success',
            position: 'bottom-right',
            toast: true,
            timer: 1500,
            showConfirmButton: false,
            width: '500px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          }).then(() => {
            setTimeout(() => {
              this.router.navigate(['/list-purchase-order']);
            }, 90);
          });
        });
    } else {
      this.servicePurchaseOrder
        .postPurchaseOrder(this.newPurchaseOrder)
        .subscribe((data) => {
          console.log('CREANDO NUEVA ORDEN DE COMPRA', data);

          Swal.fire({
            title: `Se creó con éxito la orden de compra del proveedor: ${this.newPurchaseOrder.supplier}`,
            icon: 'success',
            position: 'bottom-right',
            toast: true,
            timer: 1500,
            showConfirmButton: false,
            width: '500px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          }).then(() => {
            setTimeout(() => {
              this.router.navigate(['/list-purchase-order']);
            }, 90);
          });
        });
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
      status: 'Pendiente',
    };

    this.detailProducts = {
      idProduct: '',
      nameProduct: '',
      priceProduct: 0,
      unitProduct: 0,
    };

    this.selectedProduct.priceProduct;
    this.supplierPoin = true;
  }

  validationDate() {
    this.isDateInvalid =
      this.getDateObject(this.newPurchaseOrder.dateDelivery).getTime() <
      this.getMinDateShipping().getTime();
  }

  getMinDateShippingTemplate(): string {
    let dateShipping = this.getMinDateShipping();
    return this.datePipe.transform(dateShipping, 'yyyy-MM-dd') || '2024-01-01';
  }

  getMinDateShipping(): Date {
    const day = 1000 * 60 * 60 * 24;
    let daysDelay = 3;
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
