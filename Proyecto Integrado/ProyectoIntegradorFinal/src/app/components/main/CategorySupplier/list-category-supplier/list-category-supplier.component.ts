import { Component } from '@angular/core';
import { CategorySupplier } from '../../../../Models/supplier';
import { CategorySupplierService } from '../../../../Service/category-supplier.service';

@Component({
  selector: 'app-list-category-supplier',
  templateUrl: './list-category-supplier.component.html',
  styleUrl: './list-category-supplier.component.css',
})
export class ListCategorySupplierComponent {
  categorySupplierList!: CategorySupplier[];

  constructor(private categorySupplierService: CategorySupplierService) {}

  ngOnInit(): void {
    this.getListCategory();
  }

  getListCategory() {
    this.categorySupplierService.getCategoriesSupplier().subscribe((data) => {
      this.categorySupplierList = data;
      console.log('Cargando Lista de categorias', data);
    });
  }

  deleteCategory(id: number) {
    alert('Eliminando el rubro' + id);
    this.categorySupplierService
      .deleteCategoriesSupplier(id)
      .subscribe((data) => {
        console.log('CAMBIANDO EL DELETE', data);
        this.getListCategory();
      });
  }
}
