package com.camLecture.service.impl;

import com.camLecture.dao.ICityDao;
import com.camLecture.entity.City;
import com.camLecture.entity.Company;
import com.camLecture.service.ICityService;
import com.camLecture.service.ICompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/9.
 */
@Service("CityService")
public class CityServiceImpl implements ICityService {
    @Resource
    private ICityDao cityDao;


    public ArrayList<City> getAllCity() {
        return this.cityDao.getAllCity();
    }

    public int insert(City city) {
        return this.cityDao.insert(city);
    }

    @Override
    public int delete(City city) {
        return this.cityDao.delete(city);
    }
}
