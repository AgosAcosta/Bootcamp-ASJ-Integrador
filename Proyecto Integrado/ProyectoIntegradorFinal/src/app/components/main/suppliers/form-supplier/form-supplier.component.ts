import { Component, ViewChild } from '@angular/core';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import { Supplier } from '../../../../Models/supplier';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Ubication } from '../../../../Models/location';
import { categorySupplier } from '../../../../Models/CategorySupplier';
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

 // category: string[] = categorySupplier;
  category: string[] = [];
  newCategory: string = '';
  isModalOpen: boolean = false;
  successMessage : string |null = null;


  ubication = Ubication;
  provinces: string[] = [];
  msj: boolean = false;
  msjId: boolean = false;

 


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
        console.log(this.supplierService.getIdSupplier(id)!);

        console.log(this.newsupplier);
        this.isUpdate = true;
      }
    });
    this.countrySelected();
  }

  openModal() {
    this.newCategory = ''; 
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
    this.successMessage = null;
  }
  
  addCategory() {
    if (this.newCategory.trim() !== '') {
      this.category.push(this.newCategory );
      this.newCategory = '';
      this.successMessage = 'Categoría agregada con éxito'; 
      setTimeout(() => this.closeModal(), 1000);
    }
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
        if (
          this.supplierService.doesSupplierExist(this.newsupplier.idSupplier)
        ) {
          console.log('ya existe el proveedor');
          this.msjId = true;
          setTimeout(() => {
            this.newsupplier.idSupplier = '';
            this.msjId = false;
          }, 1500);
          return;
        }

        this.supplierService.addSupplier(this.newsupplier);
        console.log('Creando Nuevo Proveedor:', form.value);
        this.msj = true;
        setTimeout(() => {
          this.router.navigate(['/list-supplier']);
        }, 1500);
      }
    }
  }

  countrySelected() {
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
