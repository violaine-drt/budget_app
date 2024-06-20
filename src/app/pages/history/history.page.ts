import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-history',
  templateUrl: './history.page.html',
  styleUrls: ['./history.page.scss'],
})
export class HistoryPage implements OnInit {
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
  public Transactions = [
    {
      date: '11/01/2024',
      id: 1,
      amount: 70,
      description: 'Courses hebdo',
      supplier: 'Leclerc',
      color: '#9FCCDA',
      type: 'expense',
    },
    {
      date: '11/01/2024',
      id: 2,
      amount: 5,
      description: 'Achat fripes',
      supplier: 'Ding Fring',
      color: '#FF3D00',
      type: 'expense',
    },
    {
      date: '05/01/2024',
      id: 3,
      amount: 7,
      description: 'Verre au PMU',
      supplier: 'Le Balto',
      color: '#FF008A',
      type: 'expense',
    },
    {
      date: '05/01/2024',
      id: 4,
      amount: 500,
      description: 'Loyer',
      supplier: 'Agence Immo',
      color: '#306041',
      type: 'expense',
    },
    {
      date: '03/01/2024',
      id: 5,
      amount: 25,
      description: 'Consultation',
      supplier: 'Généraliste',
      color: '#55578F',
      type: 'expense',
    },
    {
      date: '03/01/2024',
      id: 6,
      amount: 1000,
      description: 'Indemnités chômage',
      supplier: 'Pôle Emploi',
      color: '#FFEB81',
      type: 'income',
    },
    {
      date: '03/01/2024',
      id: 7,
      amount: 10,
      description: 'Achat lampe',
      supplier: 'Emmaüs',
      color: '#FF3D00',
      type: 'expense',
    },
    {
      date: '01/01/2024',
      id: 8,
      amount: 4.5,
      description: 'Merguez VG',
      supplier: 'Naturalia',
      color: '#9FCCDA',
      type: 'expense',
    },
    {
      date: '01/01/2024',
      id: 9,
      amount: 40,
      description: 'Electricité mensuelle',
      supplier: 'GreenLight',
      color: '#306050',
      type: 'expense',
    },
    {
      date: '01/01/2024',
      id: 10,
      amount: 40,
      description: 'Electricité mensuelle',
      supplier: 'Le Concorde',
      color: '#FF008A',
      type: 'expense',
    },
  ];
  ngOnInit() {}
}
