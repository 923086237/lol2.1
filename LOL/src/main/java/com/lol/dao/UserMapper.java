package com.lol.dao;

import com.lol.domain.User;

public interface UserMapper {
    User findUserByNo(String no);
    void addUser(User user);
}