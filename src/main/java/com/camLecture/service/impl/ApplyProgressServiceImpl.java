package com.camLecture.service.impl;

/**
 * Created by Administrator on 2018/3/6.
 */
import com.camLecture.dao.IApplyProgressDao;
import com.camLecture.dao.ICamLectureDao;
import com.camLecture.entity.ApplyProgress;
import com.camLecture.entity.CamLecture;
import com.camLecture.service.IApplyProgressService;
import com.camLecture.service.ICamLectureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("ApplyProgressService")
public class ApplyProgressServiceImpl implements IApplyProgressService {

    @Resource
    private IApplyProgressDao applyProgressDao;

    public ApplyProgress selectPro(long camId) {
        return this.applyProgressDao.selectPro(camId);
    }
    public int insertPro(ApplyProgress applyProgress){
        return this.applyProgressDao.insertPro(applyProgress);
    }
    public ApplyProgress getPro(ApplyProgress applyProgress) {
        return this.applyProgressDao.getPro(applyProgress);
    }
    public ArrayList<ApplyProgress> getAllPro(ApplyProgress applyProgress) {
        return this.applyProgressDao.getAllPro(applyProgress);
    }
    public int update(ApplyProgress applyProgress){
     return this.applyProgressDao.update(applyProgress);
    }
    public int delete(long id){return  this.applyProgressDao.delete(id);}
}
