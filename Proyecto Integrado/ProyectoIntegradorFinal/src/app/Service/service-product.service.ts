import { Injectable } from '@angular/core';
import { Product } from '../Models/product';
import { Supplier } from '../Models/supplier';
import { productData } from '../data/productData';

@Injectable({
  providedIn: 'root',
})
export class ServiceProductService {
  productList: Product[] = [];
  //Para buscar el nombre del proveedor
  supplierList: Supplier[] = [];

  constructor() {
    this.productList = [...productData];
  }

  getListupplier(): Supplier[] {
    return this.supplierList;
  }

  getListProduct() {
    return this.productList;
  }

  addProduct(newProduct: Product) {
    this.productList.push(newProduct);

    console.log('Agregando producto:', newProduct);
  }

  deleteProduct(id: string) {
    const index = this.productList.findIndex((item) => item.idProduct === id);
    if (index !== -1) {
      this.productList.splice(index, 1);
    }
  }

  public getIdProduct(id: any): Product | undefined {
    return this.productList.find((item) => item.idProduct == id);
  }

  public updateProduct(newProduct: Product) {
    let update = this.productList.find(
      (item) => item.idProduct == newProduct.idProduct
    );
    update = newProduct;
  }

  public getProductByName(productName: string): Product | undefined {
    return this.productList.find(
      (product) => product.nameProduct === productName
    );
  }

  getProductsBySupplier(supplier: string): Product[] {
    return this.productList.filter((product) => product.supplierName === supplier);
  }

  public doesProductExist(id: string): boolean {
    return this.productList.some((product) => product.idProduct === id);
  }
}
