package com.example.selfhelpcity.bean.db;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import lombok.Data;

@Data
@Entity
public class CommuityBean {


    @Id
    private long id;


    /**
     * fy_id : 1
     * user_id : 1
     * title : 环境优美安静
     * zujin : 1800.0
     * address : 湖南长沙
     * huxing : 一室一厅
     * mianji : 48.0
     * zhuangxiu : 精装修
     * jianjie : 湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅
     * fbTime : 1574167250000
     * picture : fang1.jpg
     */
    private int fyId;
    private int userId;
    private String title;
    private double zujin;
    private String address;
    private String huxing;
    private double mianji;
    private String zhuangxiu;
    private String jianjie;
    private long fbTime;
    private String picture;
    private boolean isCollection;


}
