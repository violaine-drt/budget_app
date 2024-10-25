import {
  ComponentFixture,
  TestBed,
  fakeAsync,
  tick,
  waitForAsync,
} from '@angular/core/testing';
import { WelcomeLoginPage } from './welcome-login.page';
import { HomepagePage } from '../homepage/homepage.page';
import { IonicModule } from '@ionic/angular';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { Router } from '@angular/router';

describe('WelcomeLoginPage', () => {
  let component: WelcomeLoginPage;
  let fixture: ComponentFixture<WelcomeLoginPage>;
  let router: Router;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [WelcomeLoginPage],
      imports: [IonicModule.forRoot(), AppRoutingModule],
    }).compileComponents();
    fixture = TestBed.createComponent(WelcomeLoginPage);
    router = TestBed.get(Router);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should go to homepage after welcome', fakeAsync(() => {
    spyOn(router, 'navigate');
    component.ngOnInit();
    tick(1500);

    expect(router.navigate).toHaveBeenCalledWith(['homepage']);
  }));
});
