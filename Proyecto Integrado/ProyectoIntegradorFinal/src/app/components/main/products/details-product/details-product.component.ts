import { Component, OnInit } from '@angular/core';
import { Product } from '../../../../Models/product';
import { ServiceProductService } from '../../../../Service/service-product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-product',
  templateUrl: './details-product.component.html',
  styleUrl: './details-product.component.css',
})
export class DetailsProductComponent implements OnInit {
  product: Product | undefined;
  productId: number = -1;

  constructor(
    public serviceProduct: ServiceProductService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      let id = params['id'];
      if (id != undefined) {
        this.product = this.serviceProduct.getIdProduct(id)!;
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
