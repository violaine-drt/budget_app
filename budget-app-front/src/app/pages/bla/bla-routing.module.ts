import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BlaPage } from './bla.page';

const routes: Routes = [
  {
    path: '',
    component: BlaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BlaPageRoutingModule {}
