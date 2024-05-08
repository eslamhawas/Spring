package com.example.OnlineLibrarySW2.Controller;

import com.example.OnlineLibrarySW2.Entity.User;
import com.example.OnlineLibrarySW2.Entity.modifyuserdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.OnlineLibrarySW2.Services.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;
// import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.GetAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id) {
        Map<String, Object> response = userService.getUserById(id);
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(response);
        }
    }

    // PUT endpoint to modify user fields based on the provided option
    @PutMapping("/Modify/{option}")
    public ResponseEntity<String> modifyUser(@PathVariable int option,
            @RequestBody modifyuserdto modifyuserdto) {

        return userService.modifyUser(option, modifyuserdto);
    }
}
