package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UsersService;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService service) {
        this.usersService = service;
    }

    @GetMapping(value = "/")
    public String helloPage() {
        return "index";
    }

    @GetMapping()
    public String user(Principal principal, ModelMap modelMap) {
        modelMap.addAttribute("user", usersService.getUserByUsername(principal.getName()));
        return "user-info";
    }
}