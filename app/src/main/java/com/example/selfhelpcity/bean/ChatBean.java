package com.example.selfhelpcity.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ljy
 */
@Data
@AllArgsConstructor
public class ChatBean {
    private int id;
    private int imageId;
    private String userName;
    private String chatContent;
    private String  chatTime;
}
