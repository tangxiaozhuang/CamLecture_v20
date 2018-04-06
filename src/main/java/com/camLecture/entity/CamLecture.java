package com.camLecture.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/7.
 */
public class CamLecture {
    private long id;
    private String theme;
    private String content;
    private String address;
    private Date camDate;
    private long companyId;
    private long city;
    private String position;
    private String ref1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCamDate() {
        return camDate;
    }

    public void setCamDate(Date camDate) {
        this.camDate = camDate;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getCity() {
        return city;
    }

    public void setCity(long city) {
        this.city = city;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }
}
