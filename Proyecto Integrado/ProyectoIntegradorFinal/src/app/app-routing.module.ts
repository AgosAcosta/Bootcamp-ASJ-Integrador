import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './components/main/menu/menu.component';
import { ListSupplierComponent } from './components/main/suppliers/list-supplier/list-supplier.component';
import { FormSupplierComponent } from './components/main/suppliers/form-supplier/form-supplier.component';
import { DetailsSupplierComponent } from './components/main/suppliers/details-supplier/details-supplier.component';
import { ListProductComponent } from './components/main/products/list-product/list-product.component';
import { FormProductComponent } from './components/main/products/form-product/form-product.component';
import { DetailsProductComponent } from './components/main/products/details-product/details-product.component';
import { ListPurchaseOrderComponent } from './components/main/purchaseOrder/list-purchase-order/list-purchase-order.component';
import { FormPurchaseOrderComponent } from './components/main/purchaseOrder/form-purchase-order/form-purchase-order.component';
import { DetailsPurchaseOrderComponent } from './components/main/purchaseOrder/details-purchase-order/details-purchase-order.component';

const routes: Routes = [
  { path: '', component: MenuComponent },
  {
    path: 'list-supplier',
    children: [
      { path: '', component: ListSupplierComponent },
      { path: 'new', component: FormSupplierComponent },
      { path: ':id', component: FormSupplierComponent },
      { path: 'detail/:id', component: DetailsSupplierComponent },
    ],
  },
  {
    path: 'list-product',
    children: [
      { path: '', component: ListProductComponent },
      { path: 'new', component: FormProductComponent },
      { path: ':id', component: FormProductComponent },
      { path: 'detail/:id', component: DetailsProductComponent },
    ],
  },
  {
    path: 'list-purchase-order',
    children: [
      { path: '', component: ListPurchaseOrderComponent },
      { path: 'new', component: FormPurchaseOrderComponent },
      { path: ':id', component: FormPurchaseOrderComponent },
      { path: 'detail/:id', component: DetailsPurchaseOrderComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
