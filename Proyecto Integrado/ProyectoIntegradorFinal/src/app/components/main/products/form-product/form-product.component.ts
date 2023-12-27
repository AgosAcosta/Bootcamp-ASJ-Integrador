import { Component, OnInit } from '@angular/core';
import { Product } from '../../../../Models/product';
import { ServiceProductService } from '../../../../Service/service-product.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';

@Component({
  selector: 'app-form-product',
  templateUrl: './form-product.component.html',
  styleUrl: './form-product.component.css',
})
export class FormProductComponent implements OnInit {
  newProduct: Product = {
    urlLogo: '',
    idProduct: '',
    categoryProduct: '',
    nameProduct: '',
    descriptionProduct: '',
    priceProduct: 0,
    supplierName: '',
  };

  idProduct: string = '';
  isUpdate: boolean = false;
  supplierName: string[] = [];

  constructor(
    private serviceSupplier: ServiceSupplierService,
    public serviceProduct: ServiceProductService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((response) => {
      let id = response.get('id');
      if (id != undefined) {
        this.newProduct = this.serviceProduct.getIdProduct(id)!;
        this.isUpdate = true;
      }
    });

    this.supplierName = this.serviceSupplier
      .getListSupplier()
      .map((supplier) => supplier.nameSupplier);
  }
  createNewProduct(form: NgForm) {
    if (!form.valid) {
      console.log('Revisar los datos ingresados');
      return;
    } else {
      if (this.isUpdate) {
        this.serviceProduct.updateProduct(this.newProduct);
        console.log('Actualizando Producto:', form.value);
      } else {
        this.serviceProduct.addProduct(this.newProduct);
        console.log('Creando Nuevo Producto:', form.value);
      }
    }
  }
}