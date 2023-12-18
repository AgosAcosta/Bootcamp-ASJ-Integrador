import { Component, OnInit } from '@angular/core';
import { ServiceProveedoresService } from '../../../../Service/service-proveedores.service';

@Component({
  selector: 'app-listado-proveedores',
  templateUrl: './listado-proveedores.component.html',
  styleUrl: './listado-proveedores.component.css',
})
export class ListadoProveedoresComponent implements OnInit {
  proveedoresList: any = [];

  constructor(private proveedoresService: ServiceProveedoresService) {}

  ngOnInit(): void {
    /*
    NO FUNCIONA
    this.proveedoresService.getProveedores().subscribe((data: any) => {

      console.log(data);
      this.proveedoresList = data;
    }); */

    this.proveedoresList =  this.proveedoresService.getPrueba()
    
 
  }
}
