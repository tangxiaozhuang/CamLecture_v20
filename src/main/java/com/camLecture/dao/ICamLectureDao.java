package com.camLecture.dao;

import com.camLecture.entity.CamLecture;

import java.util.ArrayList;


/**
 * Created by Administrator on 2018/3/6.
 */

public interface ICamLectureDao {

    CamLecture selectCam(long id);
    int insertCam(CamLecture camLecture);
    CamLecture getCam(CamLecture camLecture);
    ArrayList<CamLecture> getAllCam(CamLecture camLecture);
    int delete(Long id);
    int update(CamLecture camLecture);
}