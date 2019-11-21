package com.example.selfhelpcity.bean;

import lombok.Data;

/**
 * @author CYH06
 */
@Data
public class userInfo {
    private long id;

    /**
     * code : 200
     * message :
     * data : {"user_id":1,"username":"xuych","password":"111","telephone":"12345678910","age":21,"sex":"女","gxqm":"xxxxxxxxxx","photo":"default.png"}
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
         * user_id : 1
         * username : xuych
         * password : 111
         * telephone : 12345678910
         * age : 21
         * sex : 女
         * gxqm : xxxxxxxxxx
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
