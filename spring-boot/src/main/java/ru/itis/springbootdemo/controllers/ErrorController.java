package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error/403")
    public String get403() {
        return "error/403";
    }

    @GetMapping("/error/404")
    public String get404() {
        return "error/404";
    }

    @GetMapping("/error/500")
    public String get500() {
        return "error/500";
    }
}
