import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-money-card',
  templateUrl: './money-card.component.html',
  styleUrls: ['./money-card.component.scss'],
})
export class MoneyCardComponent implements OnInit {
  @Input() expenseType: string = 'dépenses';
  @Input() expenseOperator: string = '';
  @Input() expenseAmount: number = 0;
  @Input() backgroundColor: string = '#E8FFEA';
  @Input() fontColor: string = '#306050';
  @Input() borderTop: string = '1vh solid rgb(255, 255, 255';

  constructor() {}
  ngOnInit(): void {}
}
