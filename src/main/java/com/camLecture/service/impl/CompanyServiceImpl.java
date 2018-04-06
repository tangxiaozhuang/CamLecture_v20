package com.camLecture.service.impl;

import com.camLecture.dao.ICompanyDao;
import com.camLecture.entity.Company;
import com.camLecture.service.ICompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/6.
 */
@Service("CompanyService")
public class CompanyServiceImpl implements ICompanyService{
    @Resource
    private ICompanyDao companyDao;

    public Company selectCompany(long id){
        return this.companyDao.selectCompany(id);
    }
    public Company getCompany(Company company){return this.companyDao.getCompany(company);}
    public ArrayList<Company> getAllCom(){
        return this.companyDao.getAllCom();
    }
    public int insert(Company company){return this.companyDao.insert(company);}
    public int delete(long id){return this.companyDao.delete(id);}
    public int update(Company company){return this.companyDao.update(company);}
}
