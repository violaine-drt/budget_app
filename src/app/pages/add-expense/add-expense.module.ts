import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ComponentsModule } from 'src/app/components/components.module';
import { IonicModule } from '@ionic/angular';

import { AddExpensePageRoutingModule } from './add-expense-routing.module';

import { AddExpensePage } from './add-expense.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AddExpensePageRoutingModule,
    ComponentsModule,
  ],
  declarations: [AddExpensePage],
})
export class AddExpensePageModule {}
