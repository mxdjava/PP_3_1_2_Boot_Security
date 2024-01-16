package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UsersService;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UsersService userService;
    private final RoleService roleService;

    public AdminController(UsersService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "")
    public String printAllUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("listUsers", users);
        return "admin";
    }

    @GetMapping("/create_user")
    public String createUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRoles());
        return "/admin/create_user";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete_user")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit_user")
    public String editUser(@RequestParam("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/edit_user";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam("id") long id) {
        userService.editUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/info")
    public String getUser(@RequestParam("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/info";
    }
}