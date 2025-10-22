package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        if (id > 0 && id < 100) {
             return "You have entered valid ID";
        } else {
            throw new UserIdException("You have entered invalid ID");
        }    
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        if (userName.length() > 3 && userName.length() < 15) {
            return "You have entered valid USERNAME";
        } else {
           throw new UserNameException("You have entered invalid USERNAME");
        }        
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        boolean isCPFValid = isCPF(cpf);
        if (isCPFValid) {
             return "You have entered valid CPF";
        } else {
            throw new CPFException("You have entered invalid CPF");
        }
    }

    public boolean isCPF(String CPF) {
        return CPF != null && CPF.length() > 3 && CPF.length() < 15;
    }

}
