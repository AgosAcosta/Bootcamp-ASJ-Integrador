import { Component } from '@angular/core';
import { ServiceProveedoresService } from '../../../../Service/service-proveedores.service';

@Component({
  selector: 'app-alta-proveedores',
  templateUrl: './alta-proveedores.component.html',
  styleUrl: './alta-proveedores.component.css'
})
export class AltaProveedoresComponent {
  id: number = 0; 
  razonSocial: string = '';
  cuit: number = 0;
  condicionAfip: string = '';
  rubro: string = '';
  calle: string = '';
  email: string = '';

  nuevoProveedor: any = {};

  constructor(private proveedoresService: ServiceProveedoresService) {
 
  }

  agregarProveedor() {

    this.nuevoProveedor = {
      id: this.id,
      razonSocial: this.razonSocial,
      cuit: this.cuit,
      condicionAfip: this.condicionAfip,
      rubro: this.rubro,
      calle: this.calle,
      email: this.email
    };
  

    this.proveedoresService.agregarProveedor(this.nuevoProveedor);

    this.nuevoProveedor = {};
   
  }
}
