package com.example.demo.Service;

import com.example.demo.Model.LoginModel;
import com.example.demo.Repository.Loginrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private Loginrepository userRepository;

    public List<LoginModel> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<LoginModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public LoginModel saveUser(LoginModel user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
