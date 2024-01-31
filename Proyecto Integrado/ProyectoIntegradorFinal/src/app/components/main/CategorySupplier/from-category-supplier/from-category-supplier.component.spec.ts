import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FromCategorySupplierComponent } from './from-category-supplier.component';

describe('FromCategorySupplierComponent', () => {
  let component: FromCategorySupplierComponent;
  let fixture: ComponentFixture<FromCategorySupplierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FromCategorySupplierComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FromCategorySupplierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
