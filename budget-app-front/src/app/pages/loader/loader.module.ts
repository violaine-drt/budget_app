import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { LoaderPageRoutingModule } from './loader-routing.module';

import { LoaderPage } from './loader.page';
// import { FlouzeLogoComponent } from 'src/app/components/flouze-logo/flouze-logo.component';
import {ComponentsModule} from '../../components/components.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    LoaderPageRoutingModule,
    ComponentsModule
  ],
  declarations: [
    LoaderPage,
  ]
})
export class LoaderPageModule {}
