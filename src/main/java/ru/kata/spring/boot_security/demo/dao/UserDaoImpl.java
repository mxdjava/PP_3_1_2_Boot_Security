package ru.kata.spring.boot_security.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> readAllUsers() {
        return manager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public void create(User user) {
        manager.persist(user);
    }

    @Override
    public void update(User user) {
        manager.merge(user);
    }

    @Override
    public void delete(int id) {
        User user = manager.find(User.class, id);
        manager.remove(user);
    }
}