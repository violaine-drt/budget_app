import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FlouzeLogoComponent } from './flouze-logo/flouze-logo.component';
import { MainButtonComponent } from './main-button/main-button.component';
@NgModule({
  imports: [CommonModule, IonicModule],
  declarations: [FlouzeLogoComponent, MainButtonComponent],
  exports: [FlouzeLogoComponent, MainButtonComponent],
})
export class ComponentsModule {}
