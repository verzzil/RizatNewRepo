package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.services.UsersService;

import java.util.List;


@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
     public String getUsersPage(Model model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "users_page";
     }

    @GetMapping("/users/{user-id}")
    @ResponseBody
    public ResponseEntity<UserDto> getUserById(@PathVariable("user-id") Long userId){
        return ResponseEntity.ok(usersService.getUserById(userId));
    }

    @GetMapping("/get-users")
    @ResponseBody
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(usersService.findAll());
    }

}
