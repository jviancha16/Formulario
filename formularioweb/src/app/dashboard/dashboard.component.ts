import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavComponent } from "../nav/nav.component";
import { RouterModule } from "@angular/router";
import ContactListComponent from "../contact-list/contact-list.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, NavComponent, RouterModule, ContactListComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  userLoginOn: boolean = false;
}
