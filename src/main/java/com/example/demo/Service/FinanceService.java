package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Finance;
import com.example.demo.Repository.FinanceRepository;

@Service
public class FinanceService {

    @Autowired
    private FinanceRepository repository;

    // Get all finance records
    public List<Finance> getAllRecords() {
        return repository.findAll();
    }

    // Get finance records by email
    public List<Finance> getRecordsByEmail(String email) {
        return repository.findByEmail(email);
    }

    // Create a new finance record
    public Finance createRecord(Finance record) {
        return repository.save(record);
    }

    // Update an existing finance record
    public Finance updateRecord(Finance finance) {
        return repository.save(finance);
    }

    // Delete a finance record
    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}