import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { WelcomeLoginPageRoutingModule } from './welcome-login-routing.module';

import { WelcomeLoginPage } from './welcome-login.page';
import { ComponentsModule } from 'src/app/components/components.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    WelcomeLoginPageRoutingModule,
    ComponentsModule,
  ],
  declarations: [WelcomeLoginPage],
})
export class WelcomeLoginPageModule {}
