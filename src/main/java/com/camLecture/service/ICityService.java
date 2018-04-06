package com.camLecture.service;

import com.camLecture.entity.City;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/9.
 */
public interface ICityService {
    public ArrayList<City> getAllCity();
    public int insert(City city);
    public int delete(City city);
}
