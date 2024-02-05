import { Component, OnInit } from '@angular/core';
import { CategoryProduct, Product } from '../../../../Models/product';
import { ServiceProductService } from '../../../../Service/service-product.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import { CategoryProductService } from '../../../../Service/category-product.service';
import { Supplier } from '../../../../Models/supplier';
import Swal from 'sweetalert2';

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

  newCategory: CategoryProduct = {
    idCategoryProduct: 0,
    categoryProduct: '',
  };

  suppliers: string[] = [];
  categories: string[] = [];
  supplierName: string[] = [];

  existsCode: boolean = false;
  isModalOpen: boolean = false;

  isUpdate: boolean = false;
  isSave: boolean = false;
  isSaveCategory: boolean = false;

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
    this.isSave = true;
    if (!form.valid) {
      console.log('Revisar los datos ingresados');

      Swal.fire({
        title: 'Error, revisar los campos obligatorios',
        icon: 'error',
        position: 'center',
        toast: true,
        timer: 3000,
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
      Swal.fire({
        title: 'Error, ya existe un producto con ese SKU',
        icon: 'error',
        position: 'bottom-left',
        toast: true,
        timer: 3000,
        showConfirmButton: false,
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.newProduct.codeProduct = '';
      this.isSave = false;

      return;
    } else {
      this.serviceProduct.postProduct(this.newProduct).subscribe((data) => {
        console.log('Creando un producto', data);
        Swal.fire({
          title: 'Se creó con éxito el producto',
          icon: 'success',
          position: 'bottom-left',
          toast: true,
          timer: 3000,
          showConfirmButton: false,
          width: '300px',
          customClass: {
            popup: 'custom-popup-class',
            title: 'custom-title-class',
          },
        }).then(() => {
          this.navigateToListSupplier();
        });
      });
    }
  }

  updateProduct() {
    if (this.existsCode) {
      console.log('YA EXISTE ESTE CODIGO');
      Swal.fire({
        title: 'Error, ya existe un producto con ese SKU',
        icon: 'error',
        position: 'bottom-left',
        toast: true,
        timer: 3000,
        showConfirmButton: false,
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.newProduct.codeProduct = '';
      this.isSave = false;
      return;
    } else {
      this.serviceProduct
        .updateProduct(this.newProduct.idProduct, this.newProduct)
        .subscribe((data) => {
          console.log('ACTUALIZANDO PRODUCTO', data);

          Swal.fire({
            title: 'Se actualizo con éxito el producto',
            icon: 'success',
            position: 'bottom-left',
            toast: true,
            timer: 3000,
            showConfirmButton: false,
            width: '300px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          }).then(() => {
            this.navigateToListSupplier();
          });
        });
    }
  }

  navigateToListSupplier() {
    setTimeout(() => {
      this.router.navigate(['/list-product']);
    }, 1000);
  }

  addCategory() {
    this.isSaveCategory = true;
    this.categoryProductService
      .existsNameCategory(this.newCategory.categoryProduct)
      .subscribe((existsCategory: boolean) => {
        if (existsCategory) {
          Swal.fire({
            title: 'Error, ya existe esa Categoría',
            icon: 'error',
            position: 'bottom-left',
            toast: true,
            timer: 3000,
            showConfirmButton: false,
            width: '300px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          });

          this.newCategory.categoryProduct = '';
          this.isSaveCategory = false;
          return;
        }
        this.isModalOpen = true;
        this.categoryProductService
          .postCategoriesProduct(this.newCategory)
          .subscribe((data) => {
            console.log('CREANDO NUEVO CATEGORIA', data);
            Swal.fire({
              title: 'Se agrego con éxito la nueva categoría',
              icon: 'success',
              position: 'bottom-left',
              toast: true,
              timer: 3000,
              showConfirmButton: false,
              width: '300px',
              customClass: {
                popup: 'custom-popup-class',
                title: 'custom-title-class',
              },
            });
            this.newCategory.categoryProduct = '';
            this.getListCategoryProduct();
          });
      });
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
  }
}
