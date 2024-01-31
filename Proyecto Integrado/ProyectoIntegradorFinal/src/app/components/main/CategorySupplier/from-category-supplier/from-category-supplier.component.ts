import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CategorySupplier } from '../../../../Models/supplier';
import { CategorySupplierService } from '../../../../Service/category-supplier.service';
import { ActivatedRoute, Router } from '@angular/router';

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

  msj: any;
  isUpdate: boolean = false;

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
    if (!form.valid) {
      console.log('Revisar los datos ingresados');
      return;
    }
    if (this.isUpdate) {
      this.categorySupplier
        .putCategoriesSupplier(
          this.newCategorySupplier.idCategorySupplier,
          this.newCategorySupplier
        )
        .subscribe((data) => {
          console.log('ACTUALIZANDO categoria', data);
        });
    } else {
      this.categorySupplier
        .postCategoriesSupplier(this.newCategorySupplier)
        .subscribe((data) => {
          console.log('CREANDO categoria', data);
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
