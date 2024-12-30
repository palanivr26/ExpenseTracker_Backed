package com.example.demo.Controller;

import com.example.demo.Model.Contact;
import com.example.demo.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS from the frontend (React)
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // API to save contact form data
    @PostMapping
    public ResponseEntity<Map<String, String>> saveContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);

        // Create a response map to send success message as JSON
        Map<String, String> response = new HashMap<>();
        response.put("message", "Message sent! We will get back to you shortly.");
        
        // Return the response in JSON format with HTTP status OK
        return ResponseEntity.ok(response);
    }
}
