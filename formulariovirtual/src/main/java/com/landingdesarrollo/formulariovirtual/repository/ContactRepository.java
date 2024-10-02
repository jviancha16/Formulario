package com.landingdesarrollo.formulariovirtual.repository;

import com.landingdesarrollo.formulariovirtual.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{


}
