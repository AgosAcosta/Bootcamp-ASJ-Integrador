import { Component } from '@angular/core';
import { CategoryProduct } from '../../../../Models/product';
import { CategoryProductService } from '../../../../Service/category-product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-category-product',
  templateUrl: './list-category-product.component.html',
  styleUrl: './list-category-product.component.css',
})
export class ListCategoryProductComponent {
  categoryProductList!: CategoryProduct[];

  constructor(private categoryProductService: CategoryProductService) {}

  ngOnInit(): void {
    this.getListCategory();
  }

  getListCategory() {
    this.categoryProductService.getListCategoryProduct().subscribe((data) => {
      this.categoryProductList = data;
      console.log('Cargando Lista de categorias', data);
    });
  }

  deleteCategory(id: number, category: string) {
    Swal.fire({
      title: 'Eliminar Categoría',
      text: `¿Estás seguro de que deseas eliminar el categoría ${category}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, eliminarlo',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.categoryProductService
          .deleteCategoriesProduct(id)
          .subscribe((data) => {
            console.log('CAMBIANDO EL DELETE', data);
            this.getListCategory();
          });
      }
    });
  }
}
