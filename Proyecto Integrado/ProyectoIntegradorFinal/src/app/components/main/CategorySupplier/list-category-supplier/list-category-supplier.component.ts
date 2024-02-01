import { Component } from '@angular/core';
import { CategorySupplier } from '../../../../Models/supplier';
import { CategorySupplierService } from '../../../../Service/category-supplier.service';
import Swal from 'sweetalert2';

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

  deleteCategory(id: number, category: string) {
    Swal.fire({
      title: 'Eliminar Rubro',
      text: `¿Estás seguro de que deseas eliminar el rubro ${category}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, eliminarlo',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.categorySupplierService
          .deleteCategoriesSupplier(id)
          .subscribe((data) => {
            console.log('CAMBIANDO EL DELETE', data);
            this.getListCategory();
          });
      }
    });
  }
}
