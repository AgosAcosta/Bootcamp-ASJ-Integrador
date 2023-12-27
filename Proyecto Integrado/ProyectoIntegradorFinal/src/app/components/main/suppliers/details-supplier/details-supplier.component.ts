import { Component, OnInit } from '@angular/core';
import { ServiceSupplierService } from '../../../../Service/service-supplier.service';
import { ActivatedRoute } from '@angular/router';
import { Supplier } from '../../../../Models/supplier';

@Component({
  selector: 'app-details-supplier',
  templateUrl: './details-supplier.component.html',
  styleUrl: './details-supplier.component.css',
})
export class DetailsSupplierComponent implements OnInit {
  supplier: Supplier | undefined;
  supplierId: number = -1;

  constructor(
    public serviceSuppliers: ServiceSupplierService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      let id = params['id'];
      if (id != undefined) {
        this.supplier = this.serviceSuppliers.getIdSupplier(id)!;
      }
    });
  }

  handleImageError(event: Event): void {
    const imgElement = event.target as HTMLImageElement;

    if (imgElement && imgElement.naturalWidth === 0) {
      imgElement.src =
        'https://img.freepik.com/vector-premium/icono-isometrico-bien-disenado-error-carga_203633-6310.jpg?w=2000';
    }
  }
}
