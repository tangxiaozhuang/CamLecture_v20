package com.camLecture.service;

import com.camLecture.entity.CamLecture;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/7.
 */
public interface ICamLectureService {

    CamLecture selectCam(long id);
    int insertCam(CamLecture camLecture);
    CamLecture getCam(CamLecture camLecture);
    ArrayList<CamLecture> getAllCam(CamLecture camLecture);
    int delete(long id);
    int update(CamLecture camLecture);
}
