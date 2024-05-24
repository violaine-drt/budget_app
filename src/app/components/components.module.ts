import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FlouzeLogoComponent } from './flouze-logo/flouze-logo.component';
import { MainButtonComponent } from './main-button/main-button.component';
import { MoneyCardComponent } from './money-card/money-card.component';
@NgModule({
  imports: [CommonModule, IonicModule],
  declarations: [FlouzeLogoComponent, MainButtonComponent, MoneyCardComponent],
  exports: [FlouzeLogoComponent, MainButtonComponent, MoneyCardComponent],
})
export class ComponentsModule {}
