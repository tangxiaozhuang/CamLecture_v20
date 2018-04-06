package com.camLecture.dao;

import com.camLecture.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/3/6.
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {
    @Autowired
    private IUserDao dao;
    @Test
    public void selectUser() throws Exception {
        long id = 1;
        //User user = dao.selectUser(id);
//        System.out.println(user.toString());
    }
    @Test
    public void insertUser() throws Exception {
        Date day=new Date();

        User user=new User();
        user.setUsername("qq");
        user.setCity(1);
        user.setEmail("qq");
        user.setPassword("112");
        user.setRole("root");
        user.setSchool("开发区");
        user.setStatus(0);
        user.setRegTime(day);
        int result = dao.insertUser(user);
        System.out.println(result);
    }

}