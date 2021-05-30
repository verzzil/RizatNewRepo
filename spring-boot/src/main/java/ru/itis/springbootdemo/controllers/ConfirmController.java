package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springbootdemo.services.UsersService;

@Controller
public class ConfirmController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/confirm/{code}")
    public ResponseEntity<Boolean> confirmUser(@PathVariable("code") String code){
        return ResponseEntity.ok(usersService.confirmUser(code));
    }
}
