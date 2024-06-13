import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-add-income',
  templateUrl: './add-income.page.html',
  styleUrls: ['./add-income.page.scss'],
})
export class AddIncomePage implements OnInit {
  @Input() sort: string = '../../assets/icon/asterisk.svg';

  constructor() {}

  ngOnInit() {}
}
