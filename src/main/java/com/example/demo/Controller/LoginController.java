package com.example.demo.Controller;

import com.example.demo.Model.LoginModel;
import com.example.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
//@CrossOrigin(origins="http:localhost:3000")
public class LoginController {

    @Autowired
    private LoginService userService;

    @GetMapping
    public ResponseEntity<List<LoginModel>> getAllUsers() {
        List<LoginModel> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginModel> getUserById(@PathVariable  Long id) {
        Optional<LoginModel> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<LoginModel> createUser( @RequestBody LoginModel user) {
    	LoginModel savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoginModel> updateUser(@PathVariable  Long id,  @RequestBody LoginModel user) {
        if (userService.getUserById(id).isPresent()) {
            user.setId(id);
            LoginModel updatedUser = userService.saveUser(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable  Long id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
