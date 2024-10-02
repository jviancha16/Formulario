package com.landingdesarrollo.formulariovirtual.controller;


import com.landingdesarrollo.formulariovirtual.dto.ContactDTO;
import com.landingdesarrollo.formulariovirtual.entity.Contact;
import com.landingdesarrollo.formulariovirtual.repository.ContactRepository;
import com.landingdesarrollo.formulariovirtual.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {


    private  final ContactService contactService;


    @GetMapping
    Iterable<Contact> list() {
        return contactService.findAll();
    }


    // metodo para consultar los datos que hay en una base ded atos
    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    // DTO persiste el objeto contact
    // va a viajar en el cuerpo de la solicitud @RequestBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody ContactDTO contactDTO) {
        return contactService.create(contactDTO);
    }

    //actualziar el contacto
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
                          @RequestBody ContactDTO contactDTO) {
        return contactService.update(id, contactDTO);
    }

    //Eliminar el contacto
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }
}
