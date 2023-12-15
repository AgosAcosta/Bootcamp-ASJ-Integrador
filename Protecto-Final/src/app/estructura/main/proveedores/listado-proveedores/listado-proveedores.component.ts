import { Component } from '@angular/core';

@Component({
  selector: 'app-listado-proveedores',
  templateUrl: './listado-proveedores.component.html',
  styleUrl: './listado-proveedores.component.css'
})
export class ListadoProveedoresComponent {
  formulario: any [] = [
    {
      razonsocial: 'Proveedor 1',
      cuit: '12345678901',
      condicionAfip: 'Responsable Inscripto',
      rubro: 'Alimenticio'
    },
    {
      razonsocial: 'Proveedor 2',
      cuit: '98765432109',
      condicionAfip: 'Monotributista',
      rubro: 'Tecnologico'
    },
    {
      razonsocial: 'Pepito Juarez',
      cuit: '123456789',
      condicionAfip: 'Consumidor Final',
      rubro: 'Insumos'
    },
  ]
}
