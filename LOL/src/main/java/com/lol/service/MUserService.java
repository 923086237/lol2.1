package com.lol.service;

import com.lol.domain.User;

public interface MUserService {
    User findUserByNo(String no);
    void addUser(User user);
}
