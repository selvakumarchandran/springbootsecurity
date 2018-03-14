package com.example.demo.AccountModule.controller;


import com.example.demo.AccountModule.Entity.UserEntity;
import com.example.demo.AccountModule.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountCountroller {

    @Autowired
    UserDaoImpl userDaoImpl;

    @RequestMapping(value = "svc/v1/public/{accountno}")
    public String getAccocuntDataLinkedTo(@PathVariable final int accountno)
    {
        return "public account number"+accountno;
    }


    @RequestMapping(value = "/allPersons")
    public List<UserEntity> getAllPersons() {
        try {
            return userDaoImpl.getAllUsers();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/save")
    public String create() {
        try {
            UserEntity person = new UserEntity();
            person.setName("selva");
            person.setActive(1);
            person.setLastName("selva");
            person.setEmail("test@gmail.com");
            person.setPassword("selva");
            userDaoImpl.savePerson(person);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
        return "User succesfully saved!";
    }


}
