import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCategoryProductComponent } from './list-category-product.component';

describe('ListCategoryProductComponent', () => {
  let component: ListCategoryProductComponent;
  let fixture: ComponentFixture<ListCategoryProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListCategoryProductComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListCategoryProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
