package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Finance;
import com.example.demo.Service.FinanceService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access this API
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService service;

    // Endpoint to get all records
    @GetMapping("/records")
    public List<Finance> getAllRecords() {
        return service.getAllRecords();
    }

    // Endpoint to get records by email
    @GetMapping("/records/email/{email}")
    public List<Finance> getRecordsByEmail(@PathVariable String email) {
        return service.getRecordsByEmail(email);
    }

    // Endpoint to create a new finance record
    @PostMapping("/records")
    public Finance createRecord(@RequestBody Finance record) {
        return service.createRecord(record);
    }

    // Endpoint to update an existing record
    @PutMapping("/records/{id}")
    public Finance updateRecord(@RequestBody Finance finance, @PathVariable Long id) {
        finance.setId(id); // Ensure the record gets the correct ID
        return service.updateRecord(finance);
    }

    // Endpoint to delete a record
    @DeleteMapping("/records/{id}")
    public void deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}
