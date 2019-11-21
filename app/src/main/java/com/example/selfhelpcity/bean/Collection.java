package com.example.selfhelpcity.bean;

import java.util.List;

public class Collection {

    /**
     * code : 200
     * message : null
     * data : [{"fy_id":1,"user_id":1,"title":"环境优美安静","zujin":1800,"address":"湖南长沙","huxing":"一室一厅","mianji":48,"zhuangxiu":"精装修","jianjie":"湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅","fbTime":1574167250000,"picture":"fang1.jpg"},{"fy_id":2,"user_id":1,"title":"环境优美安静","zujin":2000,"address":"湖南衡阳","huxing":"一室一厅","mianji":70,"zhuangxiu":"未装修","jianjie":"湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅","fbTime":1574159833000,"picture":"fang2.jpg"}]
     */

    private int code;
    private Object message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * fy_id : 1
         * user_id : 1
         * title : 环境优美安静
         * zujin : 1800
         * address : 湖南长沙
         * huxing : 一室一厅
         * mianji : 48
         * zhuangxiu : 精装修
         * jianjie : 湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅
         * fbTime : 1574167250000
         * picture : fang1.jpg
         */

        private int fy_id;
        private int user_id;
        private String title;
        private int zujin;
        private String address;
        private String huxing;
        private int mianji;
        private String zhuangxiu;
        private String jianjie;
        private long fbTime;
        private String picture;

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

        public int getZujin() {
            return zujin;
        }

        public void setZujin(int zujin) {
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

        public int getMianji() {
            return mianji;
        }

        public void setMianji(int mianji) {
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

        public long getFbTime() {
            return fbTime;
        }

        public void setFbTime(long fbTime) {
            this.fbTime = fbTime;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
