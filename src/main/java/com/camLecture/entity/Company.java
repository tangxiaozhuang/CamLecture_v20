package com.camLecture.entity;

/**
 * Created by Administrator on 2018/3/6.
 */
public class Company {
    private long id;
    private String comName;
    private String webSite;
    private String comIntroduct;
    private String position;

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    private String logoImg;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getComIntroduct() {
        return comIntroduct;
    }

    public void setComIntroduct(String comIntroduct) {
        this.comIntroduct = comIntroduct;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

