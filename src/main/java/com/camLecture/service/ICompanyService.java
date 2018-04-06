package com.camLecture.service;

import com.camLecture.entity.Company;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/6.
 */
public interface ICompanyService {
    public Company selectCompany(long id);
    public Company getCompany(Company company);
    public ArrayList<Company> getAllCom();
    public int insert(Company company);
    public int delete(long id);
    public int update(Company company);
}
