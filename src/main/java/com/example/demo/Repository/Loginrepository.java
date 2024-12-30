package com.example.demo.Repository;

import com.example.demo.Model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Loginrepository extends JpaRepository<LoginModel, Long> {
    // Custom query methods can be added here if needed
}
