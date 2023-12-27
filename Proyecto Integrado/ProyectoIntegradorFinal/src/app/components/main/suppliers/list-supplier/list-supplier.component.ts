import { Component } from '@angular/core';
import { Supplier } from '../../../../Models/supplier';
import { Router } from '@angular/router';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';

@Component({
  selector: 'app-list-supplier',
  templateUrl: './list-supplier.component.html',
  styleUrl: './list-supplier.component.css',
})
export class ListSupplierComponent {
  supplierList!: Supplier[];

  constructor(
    private supplierService: ServiceSupplierService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.listSupplier();
  }

  listSupplier() {
    this.supplierList = this.supplierService.getListSupplier();
  }

  deleteSupplier(id: any) {
    let msj = confirm('Desea eliminar el proveedor ' + id + '?');

    if (msj) {
      this.supplierService.deleteSupplier(id);
      this.listSupplier();
    }
  }
}
