package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface RoleService {
    List<Role> getAllUser();

    void save(Role role);
    void addUserToRole(User user);

    Role showUserById(Long id);
}