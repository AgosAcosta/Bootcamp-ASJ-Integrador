import { Component, OnInit } from '@angular/core';
import { ServiceProveedoresService } from '../../../../Service/service-proveedores.service';
import { Supplier } from '../../../../data/proveedores';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listado-proveedores',
  templateUrl: './listado-proveedores.component.html',
  styleUrl: './listado-proveedores.component.css',
})
export class ListadoProveedoresComponent implements OnInit {
  //proveedoresList: any = [];

  supplierList!: Supplier[];

  constructor(
    private proveedoresService: ServiceProveedoresService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.listSupplier();
  }

  listSupplier() {
    this.supplierList = this.proveedoresService.getListSupplier();
  }

  deleteSupplier(id: any) {
    let msj = confirm('Desea eliminar el usuario#' + id + '?');

    if (msj) {
      this.proveedoresService.deleteSupplier(id);
      this.listSupplier();
    }
  }

  updateSupplier(id: number): void {
    this.router.navigate(['/Listado-Proveedores', id]);
  }
}
