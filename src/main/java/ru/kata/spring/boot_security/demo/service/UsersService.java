package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UsersService {
    User getUserById(Long id);

    User getUserByUsername(String username);
    void addUser(User user);
    List<User> listUsers();

    void deleteUser(Long id);

    void editUser(User updateUser);
}