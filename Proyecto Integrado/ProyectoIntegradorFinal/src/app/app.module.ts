import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarComponent } from './components/header/navbar/navbar.component';
import { MenuComponent } from './components/main/menu/menu.component';
import { FormSupplierComponent } from './components/main/suppliers/form-supplier/form-supplier.component';
import { ListSupplierComponent } from './components/main/suppliers/list-supplier/list-supplier.component';
import { FormProductComponent } from './components/main/products/form-product/form-product.component';
import { ListProductComponent } from './components/main/products/list-product/list-product.component';
import { FormPurchaseOrderComponent } from './components/main/purchaseOrder/form-purchase-order/form-purchase-order.component';
import { ListPurchaseOrderComponent } from './components/main/purchaseOrder/list-purchase-order/list-purchase-order.component';
import { DetailsSupplierComponent } from './components/main/suppliers/details-supplier/details-supplier.component';
import { DetailsProductComponent } from './components/main/products/details-product/details-product.component';
import { DetailsPurchaseOrderComponent } from './components/main/purchaseOrder/details-purchase-order/details-purchase-order.component';
import { DatePipe } from '@angular/common';
import { ListCategorySupplierComponent } from './components/main/CategorySupplier/list-category-supplier/list-category-supplier.component';
import { ListCategoryProductComponent } from './components/main/CategoryProduct/list-category-product/list-category-product.component';
import { FromCategorySupplierComponent } from './components/main/CategorySupplier/from-category-supplier/from-category-supplier.component';
import { FormCategoryProductComponent } from './components/main/CategoryProduct/form-category-product/form-category-product.component';
import { SearchPipe } from './Pipe/search.pipe';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MenuComponent,
    FormSupplierComponent,
    ListSupplierComponent,
    FormProductComponent,
    ListProductComponent,
    FormPurchaseOrderComponent,
    ListPurchaseOrderComponent,
    DetailsSupplierComponent,
    DetailsProductComponent,
    DetailsPurchaseOrderComponent,
    ListCategorySupplierComponent,
    ListCategoryProductComponent,
    FromCategorySupplierComponent,
    FormCategoryProductComponent,
    SearchPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    SweetAlert2Module,
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule {}
