import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './estructura/main/main.component';
import { AltaProveedoresComponent } from './estructura/main/proveedores/alta-proveedores/alta-proveedores.component';
import { ListadoProveedoresComponent } from './estructura/main/proveedores/listado-proveedores/listado-proveedores.component';
import { AltaProductosComponent } from './estructura/main/productos/alta-productos/alta-productos.component';
import { ListadoProductosComponent } from './estructura/main/productos/listado-productos/listado-productos.component';
import { OrdenAltaComponent } from './estructura/main/orden-compra/orden-alta/orden-alta.component';
import { ListadoOrdenComponent } from './estructura/main/orden-compra/listado-orden/listado-orden.component';

const routes: Routes = [
  { path: '', component: MainComponent },
  /* { path: 'Alta-Proveedores', component: AltaProveedoresComponent }, */
  /*   {path:'Listado-Proveedores', component: ListadoProveedoresComponent}, */

  {
    path: 'Listado-Proveedores',
    children: [
      { path: '', component: ListadoProveedoresComponent },
      { path: 'new', component: AltaProveedoresComponent },
      { path: ':id', component: AltaProveedoresComponent },
    ],
  },
  { path: 'Alta-Productos', component: AltaProductosComponent },
  { path: 'Listado-Productos', component: ListadoProductosComponent },
  { path: 'Alta-Orden-de-compra', component: OrdenAltaComponent },
  { path: 'Listado-Orden-de-compra', component: ListadoOrdenComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
