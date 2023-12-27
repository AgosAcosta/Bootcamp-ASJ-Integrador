import { Component } from '@angular/core';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import { Supplier } from '../../../../Models/supplier';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Ubication } from '../../../../Models/location';
@Component({
  selector: 'app-form-supplier',
  templateUrl: './form-supplier.component.html',
  styleUrl: './form-supplier.component.css',
})
export class FormSupplierComponent {
  newsupplier: Supplier = {
    urlLogo: '',
    idSupplier: '',
    nameSupplier: '',
    cuitSupplier: 0,
    condicionAfipSupplier: '',
    categorySupplier: '',
    streetSupplier: '',
    numSupplier: 0,
    cpSupplier: 0,
    locationSupplier: '',
    provinceSupplier: '',
    countrySupplier: '',
    webSupplier: '',
    emailSupplier: '',
    telSupplier: '',
    namecontactSupplier: '',
    lastNamecontactSupplier: '',
    telcontactSupplier: '',
    emailcontactSupplier: '',
    rolcontactSupplier: '',
  };

  idSupplier: string = '';
  isUpdate: boolean = false;

  ubication = Ubication;
  provinces: string[] = [];
  msj: boolean = false;

  constructor(
    private supplierService: ServiceSupplierService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((response) => {
      let id = response.get('id');
      if (id != undefined) {
        this.newsupplier = this.supplierService.getIdSupplier(id)!;
        this.isUpdate = true;
      }
    });
  }

  createNewSupplier(form: NgForm) {
    if (!form.valid) {
      console.log('Revisar los datos ingresados');
      return;
    } else {
      if (this.isUpdate) {
        this.supplierService.updateSupplier(this.newsupplier);
        console.log('Actualizando Proveedor:', form.value);

        this.msj = true;
        setTimeout(() => {
          this.router.navigate(['/list-supplier']);
        }, 1500);
      } else {
        this.supplierService.addSupplier(this.newsupplier);
        console.log('Creando Nuevo Proveedor:', form.value);
        this.msj = true;
        setTimeout(() => {
          this.router.navigate(['/list-supplier']);
        }, 1500);
      }
    }
  }

  onCountryChange() {
    const selectedCountry = this.ubication.find(
      (item) => item.countrySupplier === this.newsupplier.countrySupplier
    );

    this.provinces = selectedCountry ? selectedCountry.locationSupplier : [];
    this.newsupplier.provinceSupplier = '';
  }

  ClearForm() {
    this.newsupplier = {
      urlLogo: '',
      idSupplier: '',
      nameSupplier: '',
      cuitSupplier: 0,
      condicionAfipSupplier: '',
      categorySupplier: '',
      streetSupplier: '',
      numSupplier: 0,
      cpSupplier: 0,
      locationSupplier: '',
      provinceSupplier: '',
      countrySupplier: '',
      webSupplier: '',
      emailSupplier: '',
      telSupplier: '',
      namecontactSupplier: '',
      lastNamecontactSupplier: '',
      telcontactSupplier: '',
      emailcontactSupplier: '',
      rolcontactSupplier: '',
    };

    this.msj = false;
  }
}
