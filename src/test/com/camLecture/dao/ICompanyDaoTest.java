package com.camLecture.dao;

import com.camLecture.entity.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/3/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ICompanyDaoTest {
    @Autowired
    private ICompanyDao dao;

    @Test
    public void selectCompany() throws Exception {
        long id = 1;
        Company user = dao.selectCompany(id);
        System.out.println(user.getComIntroduct());
    }

}