import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SortingInterfaceComponent } from './sorting-interface.component';

describe('SortingInterfaceComponent', () => {
  let component: SortingInterfaceComponent;
  let fixture: ComponentFixture<SortingInterfaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SortingInterfaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SortingInterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
