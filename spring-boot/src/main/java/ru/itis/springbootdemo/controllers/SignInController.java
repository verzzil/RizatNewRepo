package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.springbootdemo.dto.SignInDto;
import ru.itis.springbootdemo.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignInController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/signIn")
    public String getSignInPage(){
        return "sign_in_page";
    }

    @PostMapping("/signIn")
    public String signIn(SignInDto signInDto, HttpServletResponse response, HttpServletRequest request) {
        usersService.signIn(signInDto);
        return "redirect:/";
    }
}
