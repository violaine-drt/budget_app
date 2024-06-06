import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.page.html',
  styleUrls: ['./add-expense.page.scss'],
})
export class AddExpensePage implements OnInit {
  @Input() sort: string = '../../assets/icon/asterisk.svg';
  constructor() {}

  ngOnInit() {}
}
