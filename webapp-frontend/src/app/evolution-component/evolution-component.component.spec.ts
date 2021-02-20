import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvolutionComponentComponent } from './evolution-component.component';

describe('EvolutionComponentComponent', () => {
  let component: EvolutionComponentComponent;
  let fixture: ComponentFixture<EvolutionComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EvolutionComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EvolutionComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
