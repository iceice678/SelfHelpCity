package com.example.selfhelpcity.bean.db;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import lombok.Data;

@Data
@Entity
public class peopleBean {



    @Id
    private long id;

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

    private int userId;
    private String username;
    private String password;
    private String telephone;
    private int age;
    private String sex;
    private String gxqm;
    private String photo;

}
