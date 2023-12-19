package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("all", userService.readAllUsers());
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUserForm(@RequestParam("userID") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-update";
    }

    @PostMapping("/updateUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userID") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}