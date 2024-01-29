import { Component, ViewChild } from '@angular/core';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import { ConditionAfip, Supplier } from '../../../../Models/supplier';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Ubication } from '../../../../Models/location';
import { CategorySupplierService } from '../../../../Service/category-supplier.service';
import { CategorySupplier } from '../../../../Models/supplier';
import { ConditionAfipService } from '../../../../Service/condition-afip.service';

@Component({
  selector: 'app-form-supplier',
  templateUrl: './form-supplier.component.html',
  styleUrl: './form-supplier.component.css',
})
export class FormSupplierComponent {
  newsupplier: Supplier = {
    urlLogo: '',
    idSupplier: 0,
    codeSupplier: '',
    nameSupplier: '',
    cuitSupplier: '',
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

  conditionsAfip: string[] = [];
  categoriesSupplier: string[] = [];

  idSupplier: string = '';
  isUpdate: boolean = false;

  newCategory: string = '';
  isModalOpen: boolean = false;
  successMessage: string | null = null;

  ubication = Ubication;
  provinces: string[] = [];
  msj: boolean = false;
  msjId: boolean = false;

  constructor(
    private supplierService: ServiceSupplierService,
    private categorySupplierService: CategorySupplierService,
    private conditionAfipService: ConditionAfipService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((response) => {
      let id = response.get('id');
      if (id != undefined) {
        this.supplierService.getSuppliertById(Number(id)).subscribe(
          (supplier) => {
            this.newsupplier = supplier;
            this.isUpdate = true;
          },
          (error) => {
            console.error('Error al obtener el producto por ID:', error);
          }
        );
      }
    });

    this.countrySelected();
    this.getListCategorySupplier();
    this.getListConditionAfip();
  }
  getListCategorySupplier() {
    this.categorySupplierService.getCategoriesSupplier().subscribe(
      (data: CategorySupplier[]) => {
        console.log('Rubro proveedores:', data);
        this.categoriesSupplier = data.map(
          (categorySupplier: CategorySupplier) =>
            categorySupplier.categorySupplier
        );
      },
      (error) => {
        console.error('Error al obtener categorías:', error);
      }
    );
  }

  getListConditionAfip() {
    this.conditionAfipService.getConditionAfip().subscribe(
      (data: ConditionAfip[]) => {
        console.log('Condicion Afip:', data);
        this.conditionsAfip = data.map(
          (condicionAfipSupplier: ConditionAfip) =>
            condicionAfipSupplier.conditionAfip
        );
      },
      (error) => {
        console.error('Error al obtener condicion afip:', error);
      }
    );
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
      //    this.category.push(this.newCategory);
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
        this.supplierService
          .updateSupplier(this.newsupplier.idSupplier, this.newsupplier)
          .subscribe((data) => {
            console.log('Actualizando Proveedor:', form.value);
          });

        this.msj = true;
        setTimeout(() => {
          this.router.navigate(['/list-supplier']);
        }, 1500);
      } else {
        this.supplierService
          .postSupplier(this.newsupplier)
          .subscribe((data) => {
            console.log('Creando un proveedor', data);
            this.msj = true;
            setTimeout(() => {
              this.router.navigate(['/list-supplier']);
            }, 1500);
          });
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
      idSupplier: 0,
      codeSupplier: '',
      nameSupplier: '',
      cuitSupplier: '',
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
