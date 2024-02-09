import { Component, ViewChild, ElementRef } from '@angular/core';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import {
  ConditionAfip,
  Country,
  Provinces,
  Supplier,
} from '../../../../Models/supplier';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { CategorySupplierService } from '../../../../Service/category-supplier.service';
import { CategorySupplier } from '../../../../Models/supplier';
import { ConditionAfipService } from '../../../../Service/condition-afip.service';
import { UbicationService } from '../../../../Service/ubication.service';
import Swal from 'sweetalert2';

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

  newCategory: CategorySupplier = {
    idCategorySupplier: 0,
    categorySupplier: '',
  };

  conditionsAfip: string[] = [];
  categoriesSupplier: string[] = [];
  provinces: string[] = [];
  countries: string[] = [];

  existsCode: boolean = false;
  existsCuit: boolean = false;

  isUpdate: boolean = false;
  isSave: boolean = false;
  isSaveCategory: boolean = false;

  isModalOpen: boolean = false;

  constructor(
    private supplierService: ServiceSupplierService,
    private categorySupplierService: CategorySupplierService,
    private conditionAfipService: ConditionAfipService,
    private ubicationService: UbicationService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getListCountry();
    this.route.paramMap.subscribe((response) => {
      let id = response.get('id');
      if (id != undefined) {
        this.supplierService.getSuppliertById(Number(id)).subscribe(
          (supplier) => {
            this.newsupplier = supplier;
            this.isUpdate = true;
            this.onCountrySelected(supplier.countrySupplier);            
          },
          (error) => {
            console.error('Error al obtener el producto por ID:', error);
          }
        );
      }
    });
    this.getListCategorySupplier();
    this.getListConditionAfip();
  }

  getListCategorySupplier() {
    this.categorySupplierService.getCategoriesSupplier().subscribe(
      (data: CategorySupplier[]) => {
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

  getListCountry() {
    this.ubicationService.getListCountries().subscribe(
      (data: Country[]) => {
        this.countries = data.map((countries: Country) => countries.country);
      },
      (error) => {
        console.error('Error al obtener condicion afip:', error);
      }
    );
  }

  onCountrySelected(country: string) {
    const selectedCountryId =
      this.countries.findIndex((c) => c === country) + 1;
    this.ubicationService
      .getListProvincesByCountry(selectedCountryId)
      .subscribe(
        (data: Provinces[]) => {
          this.provinces = data.map(
            (provinces: Provinces) => provinces.province
          );
        },
        (error) => {
          console.error('Error al obtener provincias:', error);
        }
      );
  }

  addCategory() {
    this.isSaveCategory = true;
    this.categorySupplierService
      .existsNameCategory(this.newCategory.categorySupplier)
      .subscribe((exists: boolean) => {
        if (exists) {
          Swal.fire({
            title: 'Error, ya existe ese Rubro',
            icon: 'error',
            position: 'center',
            toast: true,
            timer: 1500,
            showConfirmButton: false,
            background: '#eff5ff',
            color:'black',
            width: '300px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          });
          this.newCategory.categorySupplier = '';
          this.isSaveCategory = false;
          return;
        }
        this.categorySupplierService
          .postCategoriesSupplier(this.newCategory)
          .subscribe((data) => {
            Swal.fire({
              title: 'Se agregó con éxito el nuevo rubro',
              icon: 'success',
              position: 'center',
              toast: true,
              timer: 1500,
              showConfirmButton: false,
              background: '#eff5ff',
              color:'black',
              width: '400px',
              customClass: {
                popup: 'custom-popup-class',
                title: 'custom-title-class',
              },
            });
            this.newCategory.categorySupplier = '';
            this.getListCategorySupplier();
          });
      });
  }

  createNewSupplier(form: NgForm) {
    this.isSave = true;
    if (!form.valid) {
      Swal.fire({
        title: 'Error, revisar los campos obligatorios',
        icon: 'error',
        position: 'center',
        toast: true,
        timer: 1500,
        showConfirmButton: false,
        background: '#eff5ff',
        color:'black',
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.isSave = false;
      return;
    }
    const cuit = form.value.cuitSupplier;
    const code = form.value.codeSupplier;

    this.supplierService.existsCode(code).subscribe((existsCode) => {
      this.existsCode = existsCode;

      this.supplierService.existsCuit(cuit).subscribe((existsCuit) => {
        this.existsCuit = existsCuit;

        if (this.isUpdate) {
          this.updateSupplier();
        } else {
          this.createSupplier();
        }
      });
    });
  }

  updateSupplier() {
    if (this.existsCode) {
      Swal.fire({
        title: 'Error, ya existe un proveedor con ese código',
        icon: 'error',
        position: 'center',
        toast: true,
        timer: 1500,
        showConfirmButton: false,
        background: '#eff5ff',
        color:'black',
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.newsupplier.codeSupplier = '';
      this.isSave = false;

      return;
    } else if (this.existsCuit) {
      Swal.fire({
        title: 'Error, ya existe un proveedor con ese CUIT',
        icon: 'error',
        position: 'center',
        toast: true,
        timer: 1500,
        showConfirmButton: false,
        background: '#eff5ff',
        color:'black',
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.newsupplier.cuitSupplier = '';
      this.isSave = false;
      return;
    } else {
      this.supplierService
        .updateSupplier(this.newsupplier.idSupplier, this.newsupplier)
        .subscribe((data) => {
          Swal.fire({
            title: `Se actualizo con éxito el proveedor ${this.newsupplier.nameSupplier}`,
            icon: 'success',
            position: 'center',
            toast: true,
            timer: 1500,
            showConfirmButton: false,
            background: '#eff5ff',
            color:'black',
            width: '400px',
            customClass: {
              popup: 'custom-popup-class',
              title: 'custom-title-class',
            },
          }).then(() => {
            this.navigateToListSupplier();
          });
        });
    }
  }

  createSupplier() {
    if (this.existsCode) {
      Swal.fire({
        title: 'Error, ya existe un proveedor con ese código',
        icon: 'error',
        position: 'center',
        toast: true,
        timer: 1500,
        showConfirmButton: false,
        background: '#eff5ff',
        color:'black',
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.newsupplier.codeSupplier = '';
      this.isSave = false;

      return;
    } else if (this.existsCuit) {
      Swal.fire({
        title: 'Error, ya existe un proveedor con ese CUIT',
        icon: 'error',
        position: 'center',
        toast: true,
        timer: 1500,
        showConfirmButton: false,
        background: '#eff5ff',
        color:'black',
        width: '300px',
        customClass: {
          popup: 'custom-popup-class',
          title: 'custom-title-class',
        },
      });
      this.newsupplier.cuitSupplier = '';
      this.isSave = false;
      return;
    } else {
      this.supplierService.postSupplier(this.newsupplier).subscribe((data) => {

        Swal.fire({
          title: `Se creó con éxito el proveedor ${this.newsupplier.nameSupplier}`,
          icon: 'success',
          position: 'center',
          toast: true,
          timer: 1500,
          showConfirmButton: false,
          background: '#eff5ff',
          color:'black',
          width: '400px',
          customClass: {
            popup: 'custom-popup-class',
            title: 'custom-title-class',
          },
        }).then(() => {
          this.navigateToListSupplier();
        });
      });
    }
  }

  navigateToListSupplier() {
    setTimeout(() => {
      this.router.navigate(['/list-supplier']);
    }, 90);
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
  }

  //MANEJO DE VALIDACION CUIT CON -
  countHyphens(cuit: string): number {
    return (cuit.match(/-/g) || []).length;
  }
}
