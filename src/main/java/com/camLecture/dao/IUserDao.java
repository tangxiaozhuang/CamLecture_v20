package com.camLecture.dao;

import com.camLecture.entity.User;

/**
 * Created by Administrator on 2018/3/6.
 */

public interface IUserDao {

    User selectUserByEmail(User user);
    int insertUser(User user);
    User getUser(User user);
    int update(User user);
}