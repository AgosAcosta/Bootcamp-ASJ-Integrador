import { Component } from '@angular/core';
import { ServiceProductoService } from '../../../../Service/service-producto.service';

@Component({
  selector: 'app-listado-productos',
  templateUrl: './listado-productos.component.html',
  styleUrl: './listado-productos.component.css'
})
export class ListadoProductosComponent {
  productosList: any = [];

    constructor(private productosService: ServiceProductoService) {}
  
    ngOnInit(): void {
      /*
      NO FUNCIONA
      this.proveedoresService.getProveedores().subscribe((data: any) => {
  
        console.log(data);
        this.proveedoresList = data;
      }); */
  
      this.productosList =  this.productosService.getProductos()
      
   
    }
 

}
