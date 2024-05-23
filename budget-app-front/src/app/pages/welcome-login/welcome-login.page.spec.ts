import { ComponentFixture, TestBed } from '@angular/core/testing';
import { WelcomeLoginPage } from './welcome-login.page';

describe('WelcomeLoginPage', () => {
  let component: WelcomeLoginPage;
  let fixture: ComponentFixture<WelcomeLoginPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(WelcomeLoginPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
