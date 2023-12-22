import { Component, OnInit } from '@angular/core';
import { ServiceProveedoresService } from '../../../../Service/service-proveedores.service';
import { NgForm } from '@angular/forms';
import { Supplier } from '../../../../data/proveedores';
import { ActivatedRoute, Route } from '@angular/router';

@Component({
  selector: 'app-alta-proveedores',
  templateUrl: './alta-proveedores.component.html',
  styleUrl: './alta-proveedores.component.css',
})
export class AltaProveedoresComponent implements OnInit {
  newsupplier: Supplier = {
    idSupplier: undefined,
    nameSupplier: '',
    cuitSupplier: '',
    condicionAfipSupplier: '',
    categorySupplier: '',
    streetSupplier: '',
    numSupplier: undefined,
    cpSupplier: undefined,
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

  //depende de como haga las validaciones

  constructor(
    private proveedoresService: ServiceProveedoresService,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {}

  createNewSupplier(form: NgForm) {
    if (!form.valid) {
      console.log('Revisar los datos ingresados');
      return;
    } else {
      this.proveedoresService.addSupplier(form.value);
      console.log('Cargando Formulario:', form.value);
    }
  }
}
