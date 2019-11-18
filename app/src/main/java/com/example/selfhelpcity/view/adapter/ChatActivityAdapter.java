package com.example.selfhelpcity.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.Constant;
import com.example.selfhelpcity.bean.db.MsgBean;

public class ChatActivityAdapter extends BaseQuickAdapter<MsgBean, BaseViewHolder> {

    private static final int TYPE_RIGHT = 1;
    private static final int TYPE_LEFT = 2;
    private static final int TYPE_TIME = 3;
    private static final int RIGHT_MESSAGE = R.layout.message_right;
    private static final int LEFT_MESSAGE = R.layout.message_left;

    public ChatActivityAdapter() {
        super(null);
        setMultiTypeDelegate(new MultiTypeDelegate<MsgBean>() {
            @Override
            protected int getItemType(MsgBean message) {
                if (String.valueOf(message.getFromId()).equals(Constant.userId)) {
                    return TYPE_RIGHT;
                }
                return TYPE_LEFT;
            }
        });
        getMultiTypeDelegate().registerItemType(TYPE_LEFT, LEFT_MESSAGE)
                .registerItemType(TYPE_RIGHT, RIGHT_MESSAGE);
    }


    @Override
    protected void convert(BaseViewHolder helper, MsgBean item) {
        if (item.getFromId().equals(Constant.userId)){
            helper.setText(R.id.right_text, item.getMsg());
        }else {
            helper.setText(R.id.left_text, item.getMsg());
        }

    }

}

