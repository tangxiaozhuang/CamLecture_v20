package com.camLecture.service.impl;

/**
 * Created by Administrator on 2018/3/6.
 */
import com.camLecture.dao.ICamLectureDao;
import com.camLecture.dao.IUserDao;
import com.camLecture.entity.CamLecture;
import com.camLecture.entity.User;
import com.camLecture.service.ICamLectureService;
import com.camLecture.service.ICompanyService;
import com.camLecture.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

@Service("CamService")
public class CamLectureServiceImpl implements ICamLectureService {

    @Resource
    private ICamLectureDao camLectureDao;

    public CamLecture selectCam(long camId) {
        return this.camLectureDao.selectCam(camId);
    }
    public int insertCam(CamLecture camLecture){
        return this.camLectureDao.insertCam(camLecture);
    }
    public CamLecture getCam(CamLecture camLecture) {
        return this.camLectureDao.getCam(camLecture);
    }
    public ArrayList<CamLecture> getAllCam(CamLecture camLecture) {
        return this.camLectureDao.getAllCam(camLecture);
    }
    public int delete(long id){
        return this.camLectureDao.delete(id);
    }
    public int update(CamLecture camLecture){return this.camLectureDao.update(camLecture);}
}
