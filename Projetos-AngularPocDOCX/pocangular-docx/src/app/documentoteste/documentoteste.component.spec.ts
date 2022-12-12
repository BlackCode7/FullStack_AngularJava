import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentotesteComponent } from './documentoteste.component';

describe('DocumentotesteComponent', () => {
  let component: DocumentotesteComponent;
  let fixture: ComponentFixture<DocumentotesteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentotesteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentotesteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
