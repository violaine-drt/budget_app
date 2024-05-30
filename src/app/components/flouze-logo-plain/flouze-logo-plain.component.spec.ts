import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { FlouzeLogoPlainComponent } from './flouze-logo-plain.component';

describe('FlouzeLogoPlainComponent', () => {
  let component: FlouzeLogoPlainComponent;
  let fixture: ComponentFixture<FlouzeLogoPlainComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ FlouzeLogoPlainComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(FlouzeLogoPlainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
