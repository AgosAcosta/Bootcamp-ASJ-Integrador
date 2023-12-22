import { Component } from '@angular/core';
import { ServiceOrdenCompraService } from '../../../../Service/service-orden-compra.service';

@Component({
  selector: 'app-listado-orden',
  templateUrl: './listado-orden.component.html',
  styleUrl: './listado-orden.component.css',
})
export class ListadoOrdenComponent {
  
  productosList: any = [];

  constructor(private ordenCompraService: ServiceOrdenCompraService) {}

  ngOnInit(): void {
    /*
    NO FUNCIONA
    this.proveedoresService.getProveedores().subscribe((data: any) => {

      console.log(data);
      this.proveedoresList = data;
    }); */

    this.productosList =  this.ordenCompraService.getOrdenCompra()
    
 
  }

}
