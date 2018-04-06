package com.camLecture.service;

import com.camLecture.entity.User;

/**
 * Created by Administrator on 2018/3/6.
 */

public interface IUserService {

    public User selectUserByEmail(User user);
    public int insertUser(User user);
    public User getUser(User user);
    public int update(User user);
}