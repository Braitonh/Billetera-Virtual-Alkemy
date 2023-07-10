package Alkemy.BilleteraVirtual.services;

import Alkemy.BilleteraVirtual.entities.User;
import Alkemy.BilleteraVirtual.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //private BCryptPasswordEncoder encrypter;

    public User saveUser (User user){

        User newUser = user;

        //newUser.setPassword(encrypter.encode(newUser.getPassword()));

        userRepository.save(newUser);

        return  newUser;

    }

}
