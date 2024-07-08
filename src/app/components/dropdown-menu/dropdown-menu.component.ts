import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { PopoverController } from '@ionic/angular';
@Component({
  selector: 'app-dropdown-menu',
  templateUrl: './dropdown-menu.component.html',
  styleUrls: ['./dropdown-menu.component.scss'],
})
export class DropdownMenuComponent implements OnInit {
  @Input() menuPosition: string = 'top-left-dropdown-menu';
  @Input() menuClass: string = 'menu';
  @Input() triggerId: string = 'default-button';
  @Input() side: string = 'bottom';
  @Input() size: string = 'auto';
  @Input() alignment: string = 'start';
  @Input() buttonSolidColor: string = '--ion-color-lightcream';
  @Input() buttonId: string = 'default-button';
  public appPages = [
    { title: 'Accueil', url: '/homepage' },
    { title: 'Nouveau revenu', url: '/add-income' },
    { title: 'Nouvelle dépense', url: '/add-expense' },
    { title: 'Mon historique', url: '/history' },
    { title: 'Mon analyse', url: '/homepage' },
    { title: 'Catégories', url: '/homepage' },
    { title: 'Mon compte', url: '/homepage' },
    { title: 'Se déconnecter', url: '/login' },
  ];
  constructor(
    private router: Router,
    private popoverController: PopoverController
  ) {}
  isCurrentPage(url: string): boolean {
    return this.router.url === url;
  }

  async onLinkClick(url: string) {
    await this.router.navigate([url]);
    const popover = await this.popoverController.getTop();
    if (popover) {
      await popover.dismiss();
    }
  }
  ngOnInit() {}
}
