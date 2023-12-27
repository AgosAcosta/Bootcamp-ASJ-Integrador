import { Component } from "@angular/core";
import { ServiceSupplierService } from "../../../../Service/service-supplier.service";
import { Supplier } from "../../../../Models/supplier";
import { ActivatedRoute } from "@angular/router";
import { NgForm } from "@angular/forms";
@Component({
  selector: "app-form-supplier",
  templateUrl: "./form-supplier.component.html",
  styleUrl: "./form-supplier.component.css",
})
export class FormSupplierComponent {
  newsupplier: Supplier = {
    urlLogo: "",
    idSupplier: "",
    nameSupplier: "",
    cuitSupplier: 0,
    condicionAfipSupplier: "",
    categorySupplier: "",
    streetSupplier: "",
    numSupplier: 0,
    cpSupplier: 0,
    locationSupplier: "",
    provinceSupplier: "",
    countrySupplier: "",
    webSupplier: "",
    emailSupplier: "",
    telSupplier: "",
    namecontactSupplier: "",
    lastNamecontactSupplier: "",
    telcontactSupplier: "",
    emailcontactSupplier: "",
    rolcontactSupplier: "",
  };

  idSupplier: string = "";
  isUpdate: boolean = false;

  constructor(
    private supplierService: ServiceSupplierService,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.route.paramMap.subscribe((response) => {
      let id = response.get("id");
      if (id != undefined) {
        this.newsupplier = this.supplierService.getIdSupplier(id)!;
        this.isUpdate = true;
      }
    });
  }
  createNewSupplier(form: NgForm) {
    if (!form.valid) {
      console.log("Revisar los datos ingresados");
      return;
    } else {
      if (this.isUpdate) {
        this.supplierService.updateSupplier(this.newsupplier);
        console.log("Actualizando Proveedor:", form.value);
      } else {
        this.supplierService.addSupplier(this.newsupplier);
        console.log("Creando Nuevo Proveedor:", form.value);
      }
    }
  }
}
