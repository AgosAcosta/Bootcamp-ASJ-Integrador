import { Component, OnInit } from '@angular/core';
import { CategoryProduct, Product } from '../../../../Models/product';
import { ServiceProductService } from '../../../../Service/service-product.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import { CategoryProductService } from '../../../../Service/category-product.service';
import { Supplier } from '../../../../Models/supplier';

@Component({
  selector: 'app-form-product',
  templateUrl: './form-product.component.html',
  styleUrl: './form-product.component.css',
})
export class FormProductComponent implements OnInit {
  newProduct: Product = {
    idProduct: 0,
    urlLogo: '',
    codeProduct: '',
    categoryProduct: '',
    nameProduct: '',
    descriptionProduct: '',
    priceProduct: 0,
    supplierName: '',
  };

  suppliers: string[] = [];
  categories: string[] = [];

  existsCode: boolean = false;

  idProduct: string = '';
  isUpdate: boolean = false;
  supplierName: string[] = [];
  msj: boolean = false;
  msjId: boolean = false;

  constructor(
    private serviceSupplier: ServiceSupplierService,
    private categoryProductService: CategoryProductService,
    public serviceProduct: ServiceProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((response) => {
      let id = response.get('id');
      if (id != undefined) {
        this.serviceProduct.getProductById(Number(id)).subscribe(
          (product) => {
            this.newProduct = product;
            this.isUpdate = true;
          },
          (error) => {
            console.error('Error al obtener el producto por ID:', error);
          }
        );
      }
      this.getListCategoryProduct();
      this.getListSupplier();
    });
  }

  getListCategoryProduct() {
    this.categoryProductService.getListCategoryProduct().subscribe(
      (data: any) => {
        if (Array.isArray(data)) {
          console.log('Categoria productos:', data);
          this.categories = data.map(
            (category: CategoryProduct) => category.categoryProduct
          );
        }
      },
      (error) => {
        console.error('ERROR EN LISTA CATEGORIA:', error);
      }
    );
  }

  getListSupplier() {
    this.serviceSupplier.getListSupplier().subscribe((data: Supplier[]) => {
      console.log('Proveedores:', data);
      this.suppliers = data.map((supplier: Supplier) => supplier.nameSupplier);
    });
  }

  createNewProduct(form: NgForm) {
    if (!form.valid) {
      console.log('Revisar los datos ingresados');
      return;
    }
    const code = form.value.codeProduct;
    this.serviceProduct.existsCode(code).subscribe((existsCode) => {
      this.existsCode = existsCode;

      if (this.isUpdate) {
        this.updateProduct();
      } else {
        this.postProduct();
      }
    });
  }

  postProduct() {
    if (this.existsCode) {
      console.log('YA EXISTE ESTE CODIGO');
      return;
    } else {
      this.serviceProduct.postProduct(this.newProduct).subscribe((data) => {
        console.log('Creando un producto', data);
        this.msj = true;
      });
    }
  }

  updateProduct() {
    if (this.existsCode) {
      console.log('YA EXISTE ESTE CODIGO');
      return;
    } else {
      this.serviceProduct
        .updateProduct(this.newProduct.idProduct, this.newProduct)
        .subscribe((data) => {
          console.log('ACTUALIZANDO PRODUCTO', data);
          this.msj = true;
          this.navigateToListSupplier();
        });
    }
  }

  navigateToListSupplier() {
    setTimeout(() => {
      this.router.navigate(['/list-product']);
    }, 1500);
  }

  ClearForm() {
    this.newProduct = {
      idProduct: 0,
      urlLogo: '',
      codeProduct: '',
      categoryProduct: '',
      nameProduct: '',
      descriptionProduct: '',
      priceProduct: 0,
      supplierName: '',
    };
    this.msj = false;
  }
}
