import { Component } from '@angular/core';
import { CategoryProduct } from '../../../../Models/product';
import { CategoryProductService } from '../../../../Service/category-product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form-category-product',
  templateUrl: './form-category-product.component.html',
  styleUrl: './form-category-product.component.css',
})
export class FormCategoryProductComponent {
  newCategoryProduct: CategoryProduct = {
    idCategoryProduct: 0,
    categoryProduct: '',
  };

  existsName: boolean = false;
  isUpdate: boolean = false;
  isSave: boolean = false;

  constructor(
    private categoryProductService: CategoryProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((response) => {
      let id = response.get('id');
      if (id != undefined) {
        this.categoryProductService
          .getCategoriesProductById(Number(id))
          .subscribe(
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
    this.isSave = true; 

    if (!form.valid) {
      Swal.fire({
        title: 'Error, revisar los campos obligatorios',
        icon: 'error',
        position: 'center',
        toast: true,
        timer: 1500,
        showConfirmButton: false,
        background: '#eff5ff',
        color: 'black',
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });

      this.isSave = false;
      return;
    }
    const name = form.value.categorySupplier;

    this.categoryProductService
      .existsNameCategory(name)
      .subscribe((existsName: boolean) => {
        if (existsName) {
          Swal.fire({
            title: 'Error, ya existe una categoría con ese nombre',
            icon: 'error',
            position: 'bottom-left',
            toast: true,
            timer: 1500,
            showConfirmButton: false,
            background: '#eff5ff',
            color: 'black',
            width: '300px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          });
          this.newCategoryProduct.categoryProduct = '';
          this.isSave = false;
        } else {
          if (this.isUpdate) {
            this.updateCategory();
          } else {
            this.postCategory();
          }
        }
      });
  }

  updateCategory() {
    if (this.existsName) {
      Swal.fire({
        title: 'Error, ya existe un categoría con ese nombre',
        icon: 'error',
        position: 'bottom-left',
        toast: true,
        timer: 1500,
        showConfirmButton: false,
        background: '#eff5ff',
        color: 'black',
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.newCategoryProduct.categoryProduct = '';
      this.isSave = false;
      return;
    } else {
      this.categoryProductService
        .putCategoriesProduct(
          this.newCategoryProduct.idCategoryProduct,
          this.newCategoryProduct
        )
        .subscribe((data) => {
          Swal.fire({
            title: 'Se actualizo con éxito la categoría',
            icon: 'success',
            position: 'center',
            toast: true,
            timer: 1500,
            showConfirmButton: false,
            background: '#eff5ff',
            color: 'black',
            width: '400px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          }).then(() => {
            this.router.navigate(['/list-category-product']);
          });
        });
    }
  }
  postCategory() {
    if (this.existsName) {
      Swal.fire({
        title: 'Error, ya existe un Rubro con ese nombre',
        icon: 'error',
        position: 'bottom-left',
        toast: true,
        timer: 1500,
        showConfirmButton: false,
        background: '#eff5ff',
        color: 'black',
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.newCategoryProduct.categoryProduct = '';
      this.isSave = false;
      return;
    } else {
      this.categoryProductService
        .postCategoriesProduct(this.newCategoryProduct)
        .subscribe((data) => {
          Swal.fire({
            title: 'Se creó con éxito la categoría',
            icon: 'success',
            position: 'center',
            toast: true,
            timer: 1500,
            showConfirmButton: false,
            background: '#eff5ff',
            color: 'black',
            width: '400px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          }).then(() => {
            this.router.navigate(['/list-category-product']);
          });
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
