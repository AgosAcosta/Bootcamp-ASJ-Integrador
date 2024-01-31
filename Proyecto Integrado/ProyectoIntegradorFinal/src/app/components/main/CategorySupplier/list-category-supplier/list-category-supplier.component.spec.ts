import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCategorySupplierComponent } from './list-category-supplier.component';

describe('ListCategorySupplierComponent', () => {
  let component: ListCategorySupplierComponent;
  let fixture: ComponentFixture<ListCategorySupplierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListCategorySupplierComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListCategorySupplierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
