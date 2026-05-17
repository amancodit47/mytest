import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  standalone: true,
  templateUrl: './profile.html',
  styleUrl: './profile.css'
})
export class Profile implements OnInit {

  user: any;

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('user') || '{}');
  }
}