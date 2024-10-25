import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';

import { IonicModule, PopoverController } from '@ionic/angular';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { DropdownMenuComponent } from './dropdown-menu.component';
import { By } from '@angular/platform-browser';
describe('DropdownMenuComponent', () => {
  let component: DropdownMenuComponent;
  let fixture: ComponentFixture<DropdownMenuComponent>;
  let router: Router;
  let popoverController: PopoverController;
  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [DropdownMenuComponent],
      imports: [
        IonicModule.forRoot(),
        AppRoutingModule,
        RouterModule.forRoot([]),
      ],
      providers: [
        {
          provide: PopoverController,
          useValue: jasmine.createSpyObj('PopoverController', [
            'create',
            'getTop',
          ]),
        },
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(DropdownMenuComponent);
    router = TestBed.inject(Router);
    popoverController = TestBed.inject(PopoverController);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have urls', () => {
    expect(component.appPages.length).toBeGreaterThan(0);
    component.appPages.forEach((page) => {
      expect(page.url).toBeTruthy();
    });
  });

  it('should navigate to the correct URL when an item is clicked', async () => {
    const navigateSpy = spyOn(router, 'navigate').and.resolveTo(true);
    const firstPage = component.appPages[0];

    await component.onLinkClick(firstPage.url);

    expect(navigateSpy).toHaveBeenCalledWith([firstPage.url]);
  });
});
