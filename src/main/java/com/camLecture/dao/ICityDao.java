package com.camLecture.dao;

import com.camLecture.entity.City;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/9.
 */
public interface ICityDao {
    ArrayList<City> getAllCity();
    int insert(City city);
    int delete(City city);
}
