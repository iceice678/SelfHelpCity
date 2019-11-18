package com.example.selfhelpcity.bean;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private String body;
    private int sentStatus;
    private int senderId;

}
