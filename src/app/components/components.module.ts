import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FlouzeLogoComponent } from './flouze-logo/flouze-logo.component';
import { MainButtonComponent } from './main-button/main-button.component';
import { FlouzeLogoPlainComponent } from './flouze-logo-plain/flouze-logo-plain.component';
@NgModule({
  imports: [CommonModule, IonicModule],
  declarations: [
    FlouzeLogoComponent,
    MainButtonComponent,
    FlouzeLogoPlainComponent,
  ],
  exports: [FlouzeLogoComponent, MainButtonComponent, FlouzeLogoPlainComponent],
})
export class ComponentsModule {}
