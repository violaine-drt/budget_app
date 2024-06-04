import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-main-button',
  templateUrl: './main-button.component.html',
  styleUrls: ['./main-button.component.scss'],
})
export class MainButtonComponent implements OnInit {
  @Input() buttonTitle: string = '';
  @Output() onClick = new EventEmitter<void>();
  constructor() {}

  ngOnInit() {}
  handleClick() {
    this.onClick.emit();
  }
}
