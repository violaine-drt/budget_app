import { Component, OnInit, Input } from '@angular/core';

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
  constructor() {}

  ngOnInit() {}
}
