import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImgaeUploadComponent } from './imgae-upload.component';

describe('ImgaeUploadComponent', () => {
  let component: ImgaeUploadComponent;
  let fixture: ComponentFixture<ImgaeUploadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ImgaeUploadComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ImgaeUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
