import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { LoginPage } from './login.page';
import { Router } from '@angular/router';
import { IonicModule } from '@ionic/angular';
import { AppRoutingModule } from 'src/app/app-routing.module';

describe('LoginPage', () => {
  let component: LoginPage;
  let fixture: ComponentFixture<LoginPage>;
  let router: Router;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [LoginPage],
      imports: [IonicModule.forRoot(), AppRoutingModule],
    }).compileComponents();
    fixture = TestBed.createComponent(LoginPage);
    router = TestBed.get(Router);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should go to welcome-login page on login', () => {
    spyOn(router, 'navigate');
    component.redirectWelcomeLogin();
    expect(router.navigate).toHaveBeenCalledWith(['welcome-login']);
  });

  it('should go to register page on register', () => {
    spyOn(router, 'navigate');
    component.redirectRegister();
    expect(router.navigate).toHaveBeenCalledWith(['register']);
  });
});
