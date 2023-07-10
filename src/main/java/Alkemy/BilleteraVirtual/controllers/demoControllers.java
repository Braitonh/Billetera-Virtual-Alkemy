package Alkemy.BilleteraVirtual.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "demo")
public class demoControllers {


    @GetMapping(path = "/hola")
    public ResponseEntity<?> HolaWord(){

        return ResponseEntity.ok("Hola mundo");

    }

}
