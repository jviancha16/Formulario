package com.landingdesarrollo.formulariovirtual.service;

import com.landingdesarrollo.formulariovirtual.dto.ContactDTO;
import com.landingdesarrollo.formulariovirtual.entity.Contact;
import com.landingdesarrollo.formulariovirtual.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {


    //private final ContactRepository contactRepository;
    @Autowired
    private ContactRepository contactRepository;

    public  Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository
                .findById(id)
                .orElse(null);
    }

    public Contact create(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setNit(contactDTO.getNit());
        contact.setNamePunto(contactDTO.getNamePunto());
        contact.setCiudad(contactDTO.getCiudad());
        contact.setPromotor(contactDTO.getPromotor());
        contact.setRtc(contactDTO.getRtc());
        contact.setTratamientoDatos(contactDTO.getTratamientoDatos());
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactDTO) {
        Contact contactFromDb = findById(id);

        contactFromDb.setName(contactDTO.getName());
        contactFromDb.setEmail(contactDTO.getEmail());
        contactFromDb.setNit(contactDTO.getNit());
        contactFromDb.setNamePunto(contactDTO.getNamePunto());
        contactFromDb.setCiudad(contactDTO.getCiudad());
        contactFromDb.setPromotor(contactDTO.getPromotor());
        contactFromDb.setRtc(contactDTO.getRtc());
        contactFromDb.setTratamientoDatos(contactDTO.getTratamientoDatos());

        return contactRepository.save(contactFromDb);
    }

    public void delete( Integer id) {

        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }
}
