package com.camLecture.dao;

import com.camLecture.entity.Company;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/6.
 */
public interface ICompanyDao {
    Company selectCompany(long id);
    Company getCompany(Company company);
    ArrayList<Company> getAllCom();
    int insert(Company company);
    int delete(long id);
    int update(Company company);
}
