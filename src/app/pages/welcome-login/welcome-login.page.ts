import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcome-login',
  templateUrl: './welcome-login.page.html',
  styleUrls: ['./welcome-login.page.scss'],
})
export class WelcomeLoginPage implements OnInit {
  constructor(private router: Router) {}

  ngOnInit() {
    setTimeout(() => this.router.navigate(['homepage']), 1000);
  }
}
