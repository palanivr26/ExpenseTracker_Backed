package com.example.demo.Service;

import com.example.demo.Model.Expense;
import com.example.demo.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get expense by ID
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    // Save a new expense (create or update)
    public Expense saveExpense(Expense expense) {
        // Ensure income is set, even if it's not passed in the request
        if (expense.getIncome() == null) {
            expense.setIncome(0.0); // Default income to 0 if it's not provided
        }
        return expenseRepository.save(expense);
    }

    // Update an existing expense by ID
    public Expense updateExpense(Long id, Expense expenseDetails) {
        Optional<Expense> existingExpense = expenseRepository.findById(id);
        if (existingExpense.isPresent()) {
            Expense expense = existingExpense.get();
            expense.setDescription(expenseDetails.getDescription());
            expense.setAmount(expenseDetails.getAmount());
            expense.setCategory(expenseDetails.getCategory());
            expense.setDate(expenseDetails.getDate());
            expense.setIncome(expenseDetails.getIncome()); // Update income as well
            return expenseRepository.save(expense);
        }
        return null;
    }

    // Delete an expense by ID
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
