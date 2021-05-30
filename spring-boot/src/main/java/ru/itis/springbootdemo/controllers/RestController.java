package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.springbootdemo.dto.PaperDto;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.services.PapersService;
import ru.itis.springbootdemo.services.UsersService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private PapersService papersService;

    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/rest/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(
                usersService.findAll()
        );
    }

    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/rest/papers")
    public ResponseEntity<List<PaperDto>> getPapers() {
        return ResponseEntity.ok(
                papersService.findAllPapers()
        );
    }

    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/rest/papers/user")
    public ResponseEntity<List<PaperDto>> getUserPapers(@RequestParam(name = "userId") Long userId) {
        return ResponseEntity.ok(
                papersService.findPapersFromUserId(userId)
        );
    }

}
