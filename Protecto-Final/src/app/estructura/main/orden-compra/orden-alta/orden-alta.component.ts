import { Component } from '@angular/core';
import { ServiceOrdenCompraService } from '../../../../Service/service-orden-compra.service';

@Component({
  selector: 'app-orden-alta',
  templateUrl: './orden-alta.component.html',
  styleUrl: './orden-alta.component.css'
})
export class OrdenAltaComponent {
id: number= 0;
fechaEmision = new Date ;
fechaEntrega= new Date;
direccion: string ="";
precio: string = "";

newOrdenCompra: any ={};

constructor(private ordenCompraService:ServiceOrdenCompraService ){};

agregarOrden(){
  this.newOrdenCompra={
    id:this.id,
   fechaEmision: this.fechaEmision,
   fechaEntrega:this.fechaEntrega,
   direccion:this.direccion,
   precio: this.precio,
  };

  this.ordenCompraService.agregarOrdenCompra(this.newOrdenCompra);
  this.newOrdenCompra={};
}




}
