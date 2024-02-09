import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CategorySupplier } from '../../../../Models/supplier';
import { CategorySupplierService } from '../../../../Service/category-supplier.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-from-category-supplier',
  templateUrl: './from-category-supplier.component.html',
  styleUrl: './from-category-supplier.component.css',
})
export class FromCategorySupplierComponent implements OnInit {
  newCategorySupplier: CategorySupplier = {
    idCategorySupplier: 0,
    categorySupplier: '',
  };

  existsName: boolean = false;
  isUpdate: boolean = false;
  isSave: boolean = false;

  constructor(
    private categorySupplier: CategorySupplierService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((response) => {
      let id = response.get('id');
      if (id != undefined) {
        this.categorySupplier.getCategoriesSupplierById(Number(id)).subscribe(
          (product) => {
            this.newCategorySupplier = product;
            this.isUpdate = true;
          },
          (error) => {
            console.error('Error al obtener el producto por ID:', error);
          }
        );
      }
    });
  }

  createNewCategorySupplier(form: NgForm) {
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

    this.categorySupplier
      .existsNameCategory(name)
      .subscribe((existsName: boolean) => {
        if (existsName) {
          Swal.fire({
            title: 'Error, ya existe un Rubro con ese nombre',
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
          this.newCategorySupplier.categorySupplier = '';
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
        title: 'Error, ya existe un Rubro con ese nombre',
        icon: 'error',
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
      });
      this.newCategorySupplier.categorySupplier = '';
      this.isSave = false;
      return;
    } else {
      this.categorySupplier
        .putCategoriesSupplier(
          this.newCategorySupplier.idCategorySupplier,
          this.newCategorySupplier
        )
        .subscribe((data) => {
          Swal.fire({
            title: 'Se actualizo con éxito el Rubro',
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
            this.router.navigate(['/list-category-supplier']);
          });
        });
    }
  }

  postCategory() {
    if (this.existsName) {
      Swal.fire({
        title: 'Error, ya existe un Rubro con ese nombre',
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
      this.newCategorySupplier.categorySupplier = '';
      this.isSave = false;
      return;
    } else {
      this.categorySupplier
        .postCategoriesSupplier(this.newCategorySupplier)
        .subscribe((data) => {
          Swal.fire({
            title: 'Se creó con éxito el Rubro',
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
            this.router.navigate(['/list-category-supplier']);
          });
        });
    }
  }

  ClearForm() {
    this.newCategorySupplier = {
      idCategorySupplier: 0,
      categorySupplier: '',
    };
  }
}
