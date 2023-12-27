import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsPurchaseOrderComponent } from './details-purchase-order.component';

describe('DetailsPurchaseOrderComponent', () => {
  let component: DetailsPurchaseOrderComponent;
  let fixture: ComponentFixture<DetailsPurchaseOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DetailsPurchaseOrderComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetailsPurchaseOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
