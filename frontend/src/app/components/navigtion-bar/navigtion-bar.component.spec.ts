import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigtionBarComponent } from './navigtion-bar.component';

describe('NavigtionBarComponent', () => {
  let component: NavigtionBarComponent;
  let fixture: ComponentFixture<NavigtionBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavigtionBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavigtionBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
