import { Component, OnInit } from '@angular/core';
import { Product } from '../../../../Models/product';
import { ServiceProductService } from '../../../../Service/service-product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrl: './list-product.component.css',
})
export class ListProductComponent implements OnInit {
  productList!: Product[];

  constructor(
    private serviceProduct: ServiceProductService,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.listProduct();
    this.sortProductsByName();
  }

  listProduct() {
    this.productList = this.serviceProduct.getListProduct();
  }

  deleteProduct(id: any) {
    let msj = confirm('Desea eliminar el producto ' + id + '?');
    if (msj) {
      this.serviceProduct.deleteProduct(id);
      this.listProduct();
    }
  }
  sortProductsByName() {
    this.productList.sort((a, b) => a.nameProduct.localeCompare(b.nameProduct));
    //Función que ordena y compara elementos
  }
}
