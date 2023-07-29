package com.shvayko.crud.dao;

import com.shvayko.crud.models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findOne(int id);
    void save(User user);
    User update(User user);
    void delete(Integer id);

}
