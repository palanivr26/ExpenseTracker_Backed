package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Finance;

public interface FinanceRepository extends JpaRepository<Finance, Long> {

    List<Finance> findByEmail(String email); // Find records by email
}
