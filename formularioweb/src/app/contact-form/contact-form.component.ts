import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ContactService } from '../services/contact.service';
import { Contact } from '../model/contact.interface';
import { CommonModule }  from '@angular/common';



@Component({
  selector: 'app-contact-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule, CommonModule],
  templateUrl: './contact-form.component.html',
  styleUrl: './contact-form.component.css'
})
export default class ContactFormComponent implements OnInit{
      private fb = inject(FormBuilder);
      private router = inject(Router);
      private route = inject(ActivatedRoute);
      private contactService = inject(ContactService);

      form?: FormGroup;
      contact?: Contact;

      ngOnInit(): void {
          const id = this.route.snapshot.paramMap.get('id');
          console.log('id', id);

          if (id){
            this.contactService.get(parseInt(id))
            .subscribe(contact => {
              this.contact = contact;
              this.form = this.fb.group({
                name: [contact.name, [Validators.required]],
                email: [contact.email, [Validators.required]],
                nit: [contact.nit, [Validators.required]],
                namePunto: [contact.namePunto, [Validators.required]],
                ciudad: [contact.ciudad, [Validators.required]],
                promotor: [contact.promotor, [Validators.required]],
                rtc: [contact.rtc, [Validators.required]],
                tratamientoDatos: [contact.tratamientoDatos, [Validators.requiredTrue]]
              });
            })
          }else
          this.form = this.fb.group({
            name: ["", [Validators.required],  Validators.maxLength(100), Validators.pattern(/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/)],
            email: ["", [Validators.required, Validators.email]],
            nit: ["", [Validators.required]],
            namePunto: ["", [Validators.required]],
            ciudad: ["", [Validators.required]],
            promotor: ["", [Validators.required]],
            rtc: ["", [Validators.required, Validators.pattern('^[0-9]*$')]],
            tratamientoDatos: ["", [Validators.requiredTrue]]
          });
      }


      save(){
        const contactForm = this.form!.value;

        if (this.contact){
          this.contactService.update(this.contact.id, contactForm)
          .subscribe(() => {
          this.router.navigate(["/inicio"]);

        });

        } else{
          
        this.contactService.create(contactForm)
        .subscribe(() => {
          this.router.navigate(["/inicio"]);

        });

        }
      }
}
