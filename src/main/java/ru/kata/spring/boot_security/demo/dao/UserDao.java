package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> readAllUsers();

    User getUserById(int id);

    void create(User user);

    void update(User user);

    void delete(int id);
}