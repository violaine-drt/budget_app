import { ComponentFixture, TestBed } from '@angular/core/testing';
import { BlaPage } from './bla.page';

describe('BlaPage', () => {
  let component: BlaPage;
  let fixture: ComponentFixture<BlaPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(BlaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
