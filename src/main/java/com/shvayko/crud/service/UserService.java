package com.shvayko.crud.service;

import com.shvayko.crud.models.User;
import com.shvayko.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findALL() {
        return repository.findAll();
    }

    public User findOne(int id) {
        Optional<User> foundUser = repository.findById(id);

        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user) {
        repository.save(user);
    }

    @Transactional
    public void update(int id, User updateUser) {
        updateUser.setId(id);
        repository.save(updateUser);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }




}
