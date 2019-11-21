package com.example.selfhelpcity.bean;

public class ReleaseInfo {

    /**
     * code : 200
     * message :
     * data : {"fy_id":1,"user_id":1,"title":"环境优美安静","zujin":1800,"address":"湖南长沙","huxing":"一室一厅","mianji":48,"zhuangxiu":null,"jianjie":"湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅","fbTime":1574167250000,"picture":"fang1.jpg","user":{"user_id":1,"username":"xuych","password":"xuych","telephone":"15570924450","age":20,"sex":"男","gxqm":"111","photo":"default.png"}}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * fy_id : 1
         * user_id : 1
         * title : 环境优美安静
         * zujin : 1800.0
         * address : 湖南长沙
         * huxing : 一室一厅
         * mianji : 48.0
         * zhuangxiu : null
         * jianjie : 湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅湖南长沙一室一厅
         * fbTime : 1574167250000
         * picture : fang1.jpg
         * user : {"user_id":1,"username":"xuych","password":"xuych","telephone":"15570924450","age":20,"sex":"男","gxqm":"111","photo":"default.png"}
         */

        private int fy_id;
        private int user_id;
        private String title;
        private double zujin;
        private String address;
        private String huxing;
        private double mianji;
        private Object zhuangxiu;
        private String jianjie;
        private long fbTime;
        private String picture;
        private UserBean user;

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

        public Object getZhuangxiu() {
            return zhuangxiu;
        }

        public void setZhuangxiu(Object zhuangxiu) {
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

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * user_id : 1
             * username : xuych
             * password : xuych
             * telephone : 15570924450
             * age : 20
             * sex : 男
             * gxqm : 111
             * photo : default.png
             */

            private int user_id;
            private String username;
            private String password;
            private String telephone;
            private int age;
            private String sex;
            private String gxqm;
            private String photo;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getGxqm() {
                return gxqm;
            }

            public void setGxqm(String gxqm) {
                this.gxqm = gxqm;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }
}
