package com.example.selfhelpcity.event;

import lombok.Data;

/**
 * 事件
 *
 * @author cyh02
 */
@Data
public class BaseEvent {
    private int action;

    public BaseEvent(int action) {
        this.action = action;
    }
}