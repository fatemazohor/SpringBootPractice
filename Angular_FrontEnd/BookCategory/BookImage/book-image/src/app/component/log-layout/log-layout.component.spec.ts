import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogLayoutComponent } from './log-layout.component';

describe('LogLayoutComponent', () => {
  let component: LogLayoutComponent;
  let fixture: ComponentFixture<LogLayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LogLayoutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LogLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
