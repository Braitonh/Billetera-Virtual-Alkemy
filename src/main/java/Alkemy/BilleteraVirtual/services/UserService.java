package Alkemy.BilleteraVirtual.services;


import Alkemy.BilleteraVirtual.entities.User;
import Alkemy.BilleteraVirtual.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> newUser(User user){

        Optional<User> res = userRepository.findByEmail(user.getEmail());

        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()){
            datos.put("Error",true);
            datos.put("message", "Usuario existente");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }else {
            userRepository.save(user);
            datos.put("data",user);
            datos.put("message", "Usuario registrado correctamente");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CREATED
            );
        }

    }



    public List<User> getAllUsers(){

        return userRepository.findAll();

    }



}
