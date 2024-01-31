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

  isModalOpen: boolean = false;
  successMessage: string | null = null;

  msj: boolean = false;
  msjId: boolean = false;

  constructor(
    private supplierService: ServiceSupplierService,
    private categorySupplierService: CategorySupplierService,
    private conditionAfipService: ConditionAfipService,
    private ubicationService: UbicationService,
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
    this.getListCategorySupplier();
    this.getListConditionAfip();
    this.getListCountry();
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

  getListCountry() {
    this.ubicationService.getListCountries().subscribe(
      (data: Country[]) => {
        console.log('Paises:', data);
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
    console.log('ID del país seleccionado:', selectedCountryId);

    this.ubicationService
      .getListProvincesByCountry(selectedCountryId)
      .subscribe(
        (data: Provinces[]) => {
          console.log('Provincias:', data);
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
    this.isModalOpen = true;
    this.categorySupplierService
      .postCategoriesSupplier(this.newCategory)
      .subscribe((data) => {
        console.log('CREANDO NUEVO RUBRO', data);
        this.getListCategorySupplier();

      });
  }

  createNewSupplier(form: NgForm) {
    if (!form.valid) {
      console.log('Revisar los datos ingresados');
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
      console.log('YA EXISTE ESTE CODIGO');
      return;
    } else if (this.existsCuit) {
      console.log('YA EXISTE ESTE CUIT');
      return;
    } else {
      this.supplierService
        .updateSupplier(this.newsupplier.idSupplier, this.newsupplier)
        .subscribe((data) => {
          console.log('Actualizando Proveedor:', data);
          this.msj = true;
          this.navigateToListSupplier();
        });
    }
  }

  createSupplier() {
    if (this.existsCode) {
      console.log('YA EXISTE ESTE CODIGO');
      return;
    } else if (this.existsCuit) {
      console.log('YA EXISTE ESTE CUIT');
      return;
    } else {
      this.supplierService.postSupplier(this.newsupplier).subscribe((data) => {
        console.log('Creando un proveedor', data);
        this.msj = true;
        this.navigateToListSupplier();
      });
    }
  }

  navigateToListSupplier() {
    setTimeout(() => {
      this.router.navigate(['/list-supplier']);
    }, 1500);
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

  //MANEJO DE VALIDACION CUIT CON -
  countHyphens(cuit: string): number {
    return (cuit.match(/-/g) || []).length;
  }
}
