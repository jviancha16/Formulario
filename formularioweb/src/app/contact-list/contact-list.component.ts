import { Component, inject, OnInit } from '@angular/core';
import { ContactService } from '../services/contact.service';
import { DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Contact } from '../model/contact.interface';
import { NavComponent } from "../nav/nav.component";
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-contact-list',
  standalone: true,
  imports: [DatePipe, RouterModule, NavComponent, CommonModule],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css'
})
export default class ContactListComponent implements OnInit{

  private contactService = inject(ContactService);
  contacts:Contact[] = [];

  ngOnInit(): void {
      this.loadAll();
  }

  loadAll(){
    this.contactService.list()
      .subscribe(contacts => {
        this.contacts = contacts;
        console.log(this.contacts);
      });
  }

  deleteContact(contact: Contact){
    this.contactService.delete(contact.id)
    .subscribe(() =>{
      this.loadAll();
    });
  }
}
