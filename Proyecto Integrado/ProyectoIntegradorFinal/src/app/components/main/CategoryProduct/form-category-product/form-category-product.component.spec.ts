import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormCategoryProductComponent } from './form-category-product.component';

describe('FormCategoryProductComponent', () => {
  let component: FormCategoryProductComponent;
  let fixture: ComponentFixture<FormCategoryProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FormCategoryProductComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormCategoryProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
