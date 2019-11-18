package com.example.selfhelpcity.bean.db;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import lombok.Data;

@Data
@Entity
public class MsgBean {
    @Id
    private long id;
    private String conversationId;
    private String fromId;
    private String msg;
    private String time;
}
