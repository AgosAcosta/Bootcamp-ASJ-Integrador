import { Component } from '@angular/core';
import { Supplier } from '../../../../Models/supplier';
import { Router } from '@angular/router';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-supplier',
  templateUrl: './list-supplier.component.html',
  styleUrl: './list-supplier.component.css',
})
export class ListSupplierComponent {
  supplierList: Supplier[] = [];
  supplierActive: boolean = true;

  currentCodeSortOrder: 'asc' | 'desc' = 'asc';
  currentNameSortOrder: 'asc' | 'desc' = 'asc';
  currentLocationSortOrder: 'asc' | 'desc' = 'asc';
  isCodeSortActive = false;
  isNameSortActive = false;
  isCountrySortActive = false;

  selectedStatus: boolean = true;

  searchName: string = '';
  searchCode: string = '';

  constructor(private supplierService: ServiceSupplierService) {}

  ngOnInit(): void {
    this.getListSupplierActive();
  }

  getListSupplierActive() {
    this.supplierActive = true;
    this.supplierService.getListSupplier().subscribe((data) => {
      this.supplierList = data;
    });
  }

  getListSupplierDelete() {
    this.supplierActive = false;
    this.supplierService.getListSupplierDelete().subscribe((data) => {
      this.supplierList = data;
    });
  }

  deleteSupplier(id: number, name: string) {
    Swal.fire({
      title: 'Eliminar proveedor',
      text: `¿Estás seguro de que deseas eliminar el proveedor ${name}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, eliminarlo',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.supplierService.deleteSupplier(id).subscribe((data) => {
          this.getListSupplierActive();
        });
      }
    });
  }

  activeSupplier(id: number, name: string) {
    Swal.fire({
      title: 'Activar proveedor',
      text: `¿Estás seguro de que deseas activar el proveedor ${name}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, activarlo',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.supplierService.activeSupplier(id).subscribe((data) => {  
          this.getListSupplierActive();
        });
      }
    });
  }

  toggleCodeSortOrder() {
    this.currentCodeSortOrder =
      this.currentCodeSortOrder === 'asc' ? 'desc' : 'asc';
    this.sortSupplierListByCode();
    this.isCodeSortActive = true;
    this.isNameSortActive = false;
    this.isCountrySortActive = false;
  }

  toggleNameSortOrder() {
    this.currentNameSortOrder =
      this.currentNameSortOrder === 'asc' ? 'desc' : 'asc';
    this.sortSupplierListByName();
    this.isCodeSortActive = false;
    this.isNameSortActive = true;
    this.isCountrySortActive = false;
  }

  sortSupplierListByCode() {
    this.supplierList.sort((a, b) => {
      const codeA = a.codeSupplier.toUpperCase();
      const codeB = b.codeSupplier.toUpperCase();

      return this.currentCodeSortOrder === 'asc'
        ? codeA.localeCompare(codeB)
        : codeB.localeCompare(codeA);
    });
  }

  sortSupplierListByName() {
    this.supplierList.sort((a, b) => {
      const nameA = a.nameSupplier.toUpperCase();
      const nameB = b.nameSupplier.toUpperCase();

      return this.currentNameSortOrder === 'asc'
        ? nameA.localeCompare(nameB)
        : nameB.localeCompare(nameA);
    });
  }

  sortLocation() {
    this.supplierList.sort((a, b) => {
      const locationA = `${a.countrySupplier}, ${a.provinceSupplier}`;
      const locationB = `${b.countrySupplier}, ${b.provinceSupplier}`;

      if (this.currentLocationSortOrder === 'asc') {
        return locationA.localeCompare(locationB);
      } else {
        return locationB.localeCompare(locationA);
      }
    });

    this.currentLocationSortOrder =
      this.currentLocationSortOrder === 'asc' ? 'desc' : 'asc';

    this.currentCodeSortOrder = 'asc';
    this.currentNameSortOrder = 'asc';
    this.isCodeSortActive = false;
    this.isNameSortActive = false;
    this.isCountrySortActive = true;
  }

  onRadioChange(): void {
    if (this.selectedStatus) {
      this.getListSupplierActive();
    } else {
      this.getListSupplierDelete();
    }
  }

  cleanFilter() {
    this.searchName = '';
    this.searchCode = '';
  }

  handleImageError(event: Event): void {
    const imgElement = event.target as HTMLImageElement;

    if (imgElement && imgElement.naturalWidth === 0) {
      imgElement.src =
        'data:image/png;base64,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';
    }
  }
}
