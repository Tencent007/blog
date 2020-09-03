package com.lyw.blog.service;

import com.lyw.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
