package Alkemy.BilleteraVirtual.controllers;

import Alkemy.BilleteraVirtual.entities.User;
import Alkemy.BilleteraVirtual.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "save")
    public ResponseEntity<?> createUser(@RequestBody User user){

        try {

           User newUser = userService.saveUser(user);

           return ResponseEntity.ok(newUser);

        }catch (Exception e){

            String message = e.getMessage();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }

    }

}
