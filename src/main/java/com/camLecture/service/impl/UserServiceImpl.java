package com.camLecture.service.impl;

/**
 * Created by Administrator on 2018/3/6.
 */
import com.camLecture.dao.IUserDao;
import com.camLecture.entity.User;
import com.camLecture.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUserByEmail(User user) {
        return this.userDao.selectUserByEmail(user);
    }
    public int insertUser(User user){
        Date date=new Date();
        user.setRegTime(date);
        return this.userDao.insertUser(user);
    }
    public User getUser(User user) {
        return this.userDao.getUser(user);
    }
    public int update(User user){return this.userDao.update(user);}

}
