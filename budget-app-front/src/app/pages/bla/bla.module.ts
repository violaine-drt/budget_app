import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { BlaPageRoutingModule } from './bla-routing.module';

import { BlaPage } from './bla.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    BlaPageRoutingModule
  ],
  declarations: [BlaPage]
})
export class BlaPageModule {}
