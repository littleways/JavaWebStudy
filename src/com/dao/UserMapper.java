package com.dao;

import com.bean.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);
    int update(User user);
    List<User> selectAllUser();
}
