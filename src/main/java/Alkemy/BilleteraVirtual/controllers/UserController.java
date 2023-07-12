package Alkemy.BilleteraVirtual.controllers;

import Alkemy.BilleteraVirtual.entities.User;
import Alkemy.BilleteraVirtual.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user){

        return userService.newUser(user);


    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){

        return userService.getAllUsers();

    }
}
