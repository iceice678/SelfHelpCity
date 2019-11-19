package com.example.selfhelpcity.bean.db;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import lombok.Data;

@Data
@Entity
public class CommuityBean {

    /**
     * fy_id : 1
     * user_id : 1
     * title : xxxxx
     * zujin : 1800.0
     * address : 湖南长沙
     * huxing : 一室一厅
     * mianji : 48.0
     * zhuangxiu : 精装
     * jianjie : xxxxxx
     * fbTime : 45650000
     * state : 1
     */
    @Id
    private long id;
    private int fy_id;
    private int user_id;
    private String title;
    private double zujin;
    private String address;
    private String huxing;
    private double mianji;
    private String zhuangxiu;
    private String jianjie;
    private int fbTime;
    private int state;

    public int getFy_id() {
        return fy_id;
    }

    public void setFy_id(int fy_id) {
        this.fy_id = fy_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getZujin() {
        return zujin;
    }

    public void setZujin(double zujin) {
        this.zujin = zujin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHuxing() {
        return huxing;
    }

    public void setHuxing(String huxing) {
        this.huxing = huxing;
    }

    public double getMianji() {
        return mianji;
    }

    public void setMianji(double mianji) {
        this.mianji = mianji;
    }

    public String getZhuangxiu() {
        return zhuangxiu;
    }

    public void setZhuangxiu(String zhuangxiu) {
        this.zhuangxiu = zhuangxiu;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public int getFbTime() {
        return fbTime;
    }

    public void setFbTime(int fbTime) {
        this.fbTime = fbTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
