import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  loginData = {
    email: '',
    password: ''
  };

  constructor(private router: Router) {}

  loginUser() {

    const storedUser = JSON.parse(localStorage.getItem('user') || '{}');

    if (
      this.loginData.email === storedUser.email &&
      this.loginData.password === storedUser.password
    ) {
      alert('Login Successful');
      this.router.navigate(['/profile']);
    } else {
      alert('Invalid Email or Password');
    }
  }
}