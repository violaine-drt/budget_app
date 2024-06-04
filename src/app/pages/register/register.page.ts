import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {
  constructor(private router: Router) {}

  ngOnInit() {}

  redirectWelcomeFirstLogin() {
    this.router.navigate(['']);
  }

  redirectLogin() {
    this.router.navigate(['login']);
  }
}
