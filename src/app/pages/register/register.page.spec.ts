import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { RegisterPage } from './register.page';
import { Router } from '@angular/router';
import { IonicModule } from '@ionic/angular';
import { AppRoutingModule } from 'src/app/app-routing.module';

describe('RegisterPage', () => {
  let component: RegisterPage;
  let fixture: ComponentFixture<RegisterPage>;
  let router: Router;
  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterPage],
      imports: [IonicModule.forRoot(), AppRoutingModule],
    }).compileComponents();
    fixture = TestBed.createComponent(RegisterPage);
    router = TestBed.get(Router);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should go to welcome-first-login page on registration', () => {
    spyOn(router, 'navigate');
    component.redirectWelcomeFirstLogin();
  });

  it('should go to login page on login button click', () => {
    spyOn(router, 'navigate');
    component.redirectLogin();
    expect(router.navigate).toHaveBeenCalledWith(['login']);
  });
});
