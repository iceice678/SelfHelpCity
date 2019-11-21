package com.example.selfhelpcity.model;

import android.content.Context;

import com.example.selfhelpcity.bean.db.CommuityBean;
import com.example.selfhelpcity.bean.db.MsgBean;
import com.example.selfhelpcity.bean.db.HotBean;
import com.example.selfhelpcity.bean.db.MsgBean_;
import com.example.selfhelpcity.bean.db.MyObjectBox;
import com.example.selfhelpcity.bean.db.peopleBean;
import com.orhanobut.logger.Logger;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;


public class ObjectBox {
    private static BoxStore boxStore;

    private static Box<HotBean> hotBeanBox;
    private static Box<MsgBean> messageBeanBox;
    private static Box<peopleBean> peopleBeanBox;
    private static Box<CommuityBean> commuityBeanBox;

    public static void init(Context context) {
        boxStore = MyObjectBox.builder()
                .androidContext(context.getApplicationContext())
                .build();

        hotBeanBox = ObjectBox.get().boxFor(HotBean.class);
        messageBeanBox = ObjectBox.get().boxFor(MsgBean.class);
        peopleBeanBox = ObjectBox.get().boxFor(peopleBean.class);
        commuityBeanBox = ObjectBox.get().boxFor(CommuityBean.class);
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

    public static Box<peopleBean> getPeopleBeanBox() {
        return peopleBeanBox;
    }

    public static Box<CommuityBean> getCommuityBeanBox() {
        return commuityBeanBox;
    }

    public static void addMessageToDB(MsgBean file) {
        getMessageBeanBox().removeAll();
        if (file != null) {
            messageBeanBox.put(file);
        }
    }

    public static void addPeopleList(List<peopleBean> file) {
        getPeopleBeanBox().removeAll();
        if (file != null) {
            peopleBeanBox.put(file);
        }
    }

    public static void addCommuityToDB(List<CommuityBean> file) {
        getCommuityBeanBox().removeAll();
        if (file != null) {
            commuityBeanBox.put(file);
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