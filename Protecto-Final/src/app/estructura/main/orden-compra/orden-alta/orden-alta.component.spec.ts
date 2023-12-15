import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdenAltaComponent } from './orden-alta.component';

describe('OrdenAltaComponent', () => {
  let component: OrdenAltaComponent;
  let fixture: ComponentFixture<OrdenAltaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OrdenAltaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OrdenAltaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
