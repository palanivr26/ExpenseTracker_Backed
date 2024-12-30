package com.example.demo.Service;

import com.example.demo.Model.Contact;
import com.example.demo.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Save the contact form data into the database
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }
}
