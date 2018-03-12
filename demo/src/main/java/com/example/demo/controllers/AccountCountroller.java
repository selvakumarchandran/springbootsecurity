package com.example.demo.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountCountroller {


    @RequestMapping(value = "svc/v1/public/{accountno}")
    public String getAccocuntDataLinkedTo(@PathVariable final int accountno)
    {
        return "public account number"+accountno;
    }





}
