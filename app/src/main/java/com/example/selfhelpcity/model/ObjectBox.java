package com.example.selfhelpcity.model;

import android.content.Context;

import com.example.selfhelpcity.bean.db.MsgBean;
import com.example.selfhelpcity.bean.db.HotBean;
import com.example.selfhelpcity.bean.db.MsgBean_;
import com.example.selfhelpcity.bean.db.MyObjectBox;
import com.orhanobut.logger.Logger;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;


public class ObjectBox {
    private static BoxStore boxStore;

    private static Box<HotBean> hotBeanBox;
    private static Box<MsgBean> messageBeanBox;

    public static void init(Context context) {
        boxStore = MyObjectBox.builder()
                .androidContext(context.getApplicationContext())
                .build();

        hotBeanBox = ObjectBox.get().boxFor(HotBean.class);
        messageBeanBox = ObjectBox.get().boxFor(MsgBean.class);
    }

    public static BoxStore get() {
        return boxStore;
    }

    public static Box<HotBean> getHotBeanBox() {
        return hotBeanBox;
    }

    public static Box<MsgBean> getMessageBeanBox() {
        return messageBeanBox;
    }

    public static void addMessageToDB(MsgBean file) {
        getMessageBeanBox().removeAll();
        if (file != null) {
            messageBeanBox.put(file);
        }
    }

    public static List<MsgBean> getMessageList(String id) {
        try {
            return messageBeanBox.query()
                    .equal(MsgBean_.fromId, id)
                    .build().find();
        } catch (Exception e) {
            Logger.d(e.getMessage());
        }
        return null;
    }
}