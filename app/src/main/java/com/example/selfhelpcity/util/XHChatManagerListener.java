package com.example.selfhelpcity.util;

import com.example.selfhelpcity.bean.db.MsgBean;
import com.example.selfhelpcity.model.ObjectBox;
import com.starrtc.starrtcsdk.apiInterface.IXHChatManagerListener;
import com.starrtc.starrtcsdk.core.im.message.XHIMMessage;

import java.text.SimpleDateFormat;

public class XHChatManagerListener implements IXHChatManagerListener {
    @Override
    public void onReceivedMessage(XHIMMessage message) {

        MsgBean messageBean = new MsgBean();
        messageBean.setConversationId(message.fromId);
        messageBean.setTime(new SimpleDateFormat("MM-dd HH:mm").format(new java.util.Date()));
        messageBean.setMsg(message.contentData);
        messageBean.setFromId(message.fromId);
//        MLOC.saveMessage(messageBean);
        ObjectBox.addMessageToDB(messageBean);
        AEvent.notifyListener(AEvent.AEVENT_C2C_REV_MSG, true, message);
    }

    @Override
    public void onReceivedSystemMessage(XHIMMessage message) {
        MsgBean messageBean = new MsgBean();
        messageBean.setConversationId(message.fromId);
        messageBean.setTime(new SimpleDateFormat("MM-dd HH:mm").format(new java.util.Date()));
        messageBean.setMsg(message.contentData);
        messageBean.setFromId(message.fromId);
//        MLOC.saveMessage(messageBean);
        ObjectBox.addMessageToDB(messageBean);
        AEvent.notifyListener(AEvent.AEVENT_REV_SYSTEM_MSG, true, message);
    }
}
