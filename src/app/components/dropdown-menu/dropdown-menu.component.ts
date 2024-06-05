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
  @Input() trigger: string = 'bottom-start';
  @Input() side: string = 'bottom';
  @Input() size: string = 'auto';
  @Input() alignment: string = 'start';
  @Input() buttonSolidColor: string = '--ion-color-lightcream';
  @Input() menuSide: string = 'bottom-start';
  public appPages = [
    { title: 'Accueil', url: '/homepage', icon: 'mail' },
    { title: 'Nouveau revenu', url: '/homepage', icon: 'mail' },
    { title: 'Nouvelle dépense', url: '/homepage', icon: 'paper-plane' },
    { title: 'Mon historique', url: '/homepage', icon: 'heart' },
    { title: 'Mon analyse', url: '/homepage', icon: 'trash' },
    { title: 'Catégories', url: '/homepage', icon: 'archive' },
    { title: 'Mon compte', url: '/homepage', icon: 'archive' },
    { title: 'Se déconnecter', url: '/login', icon: 'warning' },
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
