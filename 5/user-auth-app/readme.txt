Complete Updated Steps for Angular 17+ User Authentication Assignment (VS Code)

Your Angular version is the new standalone Angular structure, so follow these exact updated steps.

This project will have:

Register User
Login User
Show User Data on Profile Page
STEP 1 — Install Requirements
Install Node.js

Download and install:

Node.js Official Website

Check installation:

node -v
npm -v
STEP 2 — Install Angular CLI

Open VS Code terminal:

npm install -g @angular/cli

Check Angular version:

ng version
STEP 3 — Create Angular Project
ng new user-auth-app

Choose:

Would you like to enable Server-Side Rendering (SSR) and Static Site Generation (SSG/Prerendering)? → No

Would you like to use routing? → Yes

Stylesheet format → CSS
STEP 4 — Open Project
cd user-auth-app
code .
STEP 5 — Create Components

Open terminal in VS Code:

ng g c register
ng g c login
ng g c profile

Now your structure becomes:

src/app/
│
├── login/
├── profile/
├── register/
├── app.ts
├── app.html
├── app.css
├── app.routes.ts
└── app.config.ts
STEP 6 — Configure Routes

Open:

src/app/app.routes.ts

Replace everything with:

import { Routes } from '@angular/router';

import { Register } from './register/register';
import { Login } from './login/login';
import { Profile } from './profile/profile';

export const routes: Routes = [
  { path: '', component: Register },
  { path: 'login', component: Login },
  { path: 'profile', component: Profile }
];
STEP 7 — Configure app.config.ts

Open:

src/app/app.config.ts

Replace with:

import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes)]
};
STEP 8 — Update app.html

Open:

src/app/app.html

Replace everything with:

<h1>User Authentication App</h1>

<nav>
  <a routerLink="/">Register</a> |
  <a routerLink="/login">Login</a> |
  <a routerLink="/profile">Profile</a>
</nav>

<hr>

<router-outlet></router-outlet>
STEP 9 — Update app.ts

Open:

src/app/app.ts

Replace everything with:

import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
}
STEP 10 — Register Component
Open:
src/app/register/register.ts

Replace with:

import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {

  user = {
    name: '',
    email: '',
    password: ''
  };

  constructor(private router: Router) {}

  registerUser() {
    localStorage.setItem('user', JSON.stringify(this.user));
    alert('Registration Successful');
    this.router.navigate(['/login']);
  }
}
STEP 11 — Register HTML

Open:

src/app/register/register.html

Replace with:

<h2>Register User</h2>

<form (ngSubmit)="registerUser()">

  <label>Name:</label><br>
  <input type="text" [(ngModel)]="user.name" name="name" required>
  <br><br>

  <label>Email:</label><br>
  <input type="email" [(ngModel)]="user.email" name="email" required>
  <br><br>

  <label>Password:</label><br>
  <input type="password" [(ngModel)]="user.password" name="password" required>
  <br><br>

  <button type="submit">Register</button>

</form>
STEP 12 — Login Component

Open:

src/app/login/login.ts

Replace with:

import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
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
STEP 13 — Login HTML

Open:

src/app/login/login.html

Replace with:

<h2>Login User</h2>

<form (ngSubmit)="loginUser()">

  <label>Email:</label><br>
  <input type="email" [(ngModel)]="loginData.email" name="email" required>
  <br><br>

  <label>Password:</label><br>
  <input type="password" [(ngModel)]="loginData.password" name="password" required>
  <br><br>

  <button type="submit">Login</button>

</form>
STEP 14 — Profile Component

Open:

src/app/profile/profile.ts

Replace with:

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.html',
  styleUrl: './profile.css'
})
export class Profile implements OnInit {

  user: any;

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('user') || '{}');
  }
}
STEP 15 — Profile HTML

Open:

src/app/profile/profile.html

Replace with:

<h2>User Profile</h2>

<p><strong>Name:</strong> {{ user.name }}</p>

<p><strong>Email:</strong> {{ user.email }}</p>
STEP 16 — IMPORTANT FIX (Standalone Components)

Open each component TS file and add:

standalone: true,

Example:

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})

Do this for:

register.ts
login.ts
profile.ts
STEP 17 — Run Project

Open terminal:

ng serve

OR

ng serve -o
STEP 18 — Output
Register Page

Enter:

Name
Email
Password

Click Register.

Login Page

Login using same email/password.

Profile Page

Shows:

Name
Email
STEP 19 — If Angular Errors Come

Run:

npm install

Then:

ng serve
STEP 20 — Final Folder Structure
src/app/

login/
  login.ts
  login.html
  login.css

profile/
  profile.ts
  profile.html
  profile.css

register/
  register.ts
  register.html
  register.css

app.ts
app.html
app.css
app.routes.ts
app.config.ts