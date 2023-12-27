import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsSupplierComponent } from './details-supplier.component';

describe('DetailsSupplierComponent', () => {
  let component: DetailsSupplierComponent;
  let fixture: ComponentFixture<DetailsSupplierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DetailsSupplierComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetailsSupplierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
