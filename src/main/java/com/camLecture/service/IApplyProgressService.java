package com.camLecture.service;

import com.camLecture.entity.ApplyProgress;
import com.camLecture.entity.CamLecture;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/7.
 */
public interface IApplyProgressService {

    ApplyProgress selectPro(long id);
    int insertPro(ApplyProgress applyProgress);
    ApplyProgress getPro(ApplyProgress applyProgress);
    ArrayList<ApplyProgress> getAllPro(ApplyProgress applyProgress);
    int update(ApplyProgress applyProgress);
    int delete(long id);
}
