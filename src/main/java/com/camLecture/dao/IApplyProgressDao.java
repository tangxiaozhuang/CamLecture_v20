package com.camLecture.dao;

import com.camLecture.entity.ApplyProgress;
import com.camLecture.entity.CamLecture;

import java.util.ArrayList;


/**
 * Created by Administrator on 2018/3/6.
 */

public interface IApplyProgressDao {

    ApplyProgress selectPro(long id);
    int insertPro(ApplyProgress applyProgress);
    ApplyProgress getPro(ApplyProgress applyProgress);
    ArrayList<ApplyProgress> getAllPro(ApplyProgress applyProgress);
    int update(ApplyProgress applyProgress);
    int delete(long id);
}