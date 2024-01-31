import { Component } from '@angular/core';
import { CategoryProduct } from '../../../../Models/product';
import { CategoryProductService } from '../../../../Service/category-product.service';

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

  deleteCategory(id: number) {
    alert('Eliminando la categoria' + id);
    this.categoryProductService
      .deleteCategoriesProduct(id)
      .subscribe((data) => {
        console.log('CAMBIANDO EL DELETE', data);
        this.getListCategory();
      });
  }
}
