import { Component } from '@angular/core';
import { CategoryProduct } from '../../../../Models/product';
import { CategoryProductService } from '../../../../Service/category-product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-form-category-product',
  templateUrl: './form-category-product.component.html',
  styleUrl: './form-category-product.component.css'
})
export class FormCategoryProductComponent {
  newCategoryProduct: CategoryProduct = {
    idCategoryProduct: 0,
    categoryProduct: '',
  };

  msj: any;
  isUpdate: boolean = false;

  constructor(
    private categoryProductService: CategoryProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((response) => {
      let id = response.get('id');
      if (id != undefined) {
        this.categoryProductService.getCategoriesProductById(Number(id)).subscribe(
          (product) => {
            this.newCategoryProduct = product;
            this.isUpdate = true;
          },
          (error) => {
            console.error('Error al obtener el producto por ID:', error);
          }
        );
      }
    });
  }

  createnewCategoryProduct(form: NgForm) {
    if (!form.valid) {
      console.log('Revisar los datos ingresados');
      return;
    }
    if (this.isUpdate) {
      this.categoryProductService
        .putCategoriesProduct(
          this.newCategoryProduct.idCategoryProduct,
          this.newCategoryProduct
        )
        .subscribe((data) => {
          console.log('ACTUALIZANDO categoria', data);
        });
    } else {
      this.categoryProductService
        .postCategoriesProduct(this.newCategoryProduct)
        .subscribe((data) => {
          console.log('CREANDO categoria', data);
        });
    }
  }

  ClearForm() {
    this.newCategoryProduct = {
      idCategoryProduct: 0,
      categoryProduct: '',
    };
  }
}
