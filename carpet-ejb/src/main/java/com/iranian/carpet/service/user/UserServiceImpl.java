package com.iranian.carpet.service.user;

import com.iranian.carpet.dao.user.UserDao;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserServiceImpl implements UserService{
    @Inject
    private UserDao userDao;
}
