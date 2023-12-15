import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './estructura/footer/footer/footer.component';
import { NarvarComponent } from './estructura/header/narvar/narvar.component';
import { MainComponent } from './estructura/main/main.component';
import { ProveedoresComponent } from './estructura/main/proveedores/proveedores.component';
import { AltaProveedoresComponent } from './estructura/main/proveedores/alta-proveedores/alta-proveedores.component';
import { ListadoProveedoresComponent } from './estructura/main/proveedores/listado-proveedores/listado-proveedores.component';
import { ProductosComponent } from './estructura/main/productos/productos.component';
import { AltaProductosComponent } from './estructura/main/productos/alta-productos/alta-productos.component';
import { ListadoProductosComponent } from './estructura/main/productos/listado-productos/listado-productos.component';
import { OrdenCompraComponent } from './estructura/main/orden-compra/orden-compra.component';
import { OrdenAltaComponent } from './estructura/main/orden-compra/orden-alta/orden-alta.component'; 
import { ListadoOrdenComponent } from './estructura/main/orden-compra/listado-orden/listado-orden.component';
import { OpcionesComponent } from './estructura/main/opciones/opciones.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NarvarComponent,
    MainComponent,
    ProveedoresComponent,
    AltaProveedoresComponent,
    ListadoProveedoresComponent,
    ProductosComponent,
    AltaProductosComponent,
    ListadoProductosComponent,
    OrdenCompraComponent,
    OrdenAltaComponent,
    ListadoOrdenComponent,
    OpcionesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
