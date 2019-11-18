package com.example.selfhelpcity.bean;

import lombok.Data;

/**
 * @author CYH06
 */
@Data
public class userInfo {
    private long id;
    private int userId;
    private String userAccount;
    private String password;
    private String phone;
    private String gender;
}
