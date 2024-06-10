import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.page.html',
  styleUrls: ['./homepage.page.scss'],
})
export class HomepagePage implements OnInit {
  dateStart: string;
  dateEnd: string;
  showStartModal: boolean = false;
  showEndModal: boolean = false;
  constructor() {
    const currentDate = new Date();
    this.dateStart = currentDate.toISOString();
    this.dateEnd = currentDate.toISOString();
  }
  updateDateStart(event: any) {
    this.dateStart = event.detail.value;
  }

  updateDateEnd(event: any) {
    this.dateEnd = event.detail.value;
  }
  openStartModal() {
    this.showStartModal = true;
  }

  closeStartModal() {
    this.showStartModal = false;
  }
  openEndModal() {
    this.showEndModal = true;
  }

  closeEndModal() {
    this.showEndModal = false;
  }

  submitDates() {
    console.log('Date de début:', this.dateStart);
    console.log('Date de fin:', this.dateEnd);
    if (new Date(this.dateStart) > new Date(this.dateEnd)) {
      alert('La date de début doit être avant la date de fin.');
    } else {
      alert(`Période sélectionnée: Du ${this.dateStart} au ${this.dateEnd}`);
    }
  }
  ngOnInit() {}
}
