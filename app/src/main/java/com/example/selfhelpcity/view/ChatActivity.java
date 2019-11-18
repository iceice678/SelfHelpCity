package com.example.selfhelpcity.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.selfhelpcity.R;
import com.example.selfhelpcity.adapter.ChatActivityAdapter;
import com.example.selfhelpcity.base.BaseActivity;
import com.example.selfhelpcity.bean.db.MsgBean;
import com.example.selfhelpcity.model.ObjectBox;
import com.example.selfhelpcity.util.AEvent;
import com.example.selfhelpcity.util.IEventListener;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback;
import com.starrtc.starrtcsdk.core.im.message.XHIMMessage;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.OnClick;
import comenjoy.com.imageloadlibrary.GlideUtil;
/**
 * 聊天界面
 */
public class ChatActivity extends BaseActivity implements IEventListener {

    @BindView(R.id.chat_back)
    ImageView chatBack;
    @BindView(R.id.chat_head)
    ImageView chatHead;
    @BindView(R.id.chat_name)
    TextView chatName;
    @BindView(R.id.chat_more)
    ImageView chatMore;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.chat_rv)
    RecyclerView chatRv;
    @BindView(R.id.chat_sr)
    SwipeRefreshLayout chatSr;
    @BindView(R.id.chat_et)
    EditText chatEt;
    @BindView(R.id.chat_send)
    Button chatSend;
    @BindView(R.id.chat_bottom)
    LinearLayout chatBottom;
    @BindView(R.id.chat_content)
    LinearLayout chatContent;
    private InputMethodManager mInputManager;
    private ChatActivityAdapter chatActivityAdapter;
    private String mTargetId;
//    private List<MessageBean> mDatas;

    @Override
    protected int getContentView() {
        return R.layout.activity_chat;
    }

    @Override
    protected void init(Bundle bundle) {
        mInputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        );
    }

    @Override
    protected void initView() {
        String intent = getIntent().getStringExtra("targetId");
        if (!intent.isEmpty()) {
            mTargetId = intent;
        }
        addListener();
        chatSr.setEnabled(false);
        GlideUtil.getInstance().loadCircleImage(ChatActivity.this, R.mipmap.bsd, chatHead);
    }


    @Override
    protected void initData() {
        chatActivityAdapter = new ChatActivityAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChatActivity.this);
        linearLayoutManager.setStackFromEnd(false);
        chatRv.setLayoutManager(linearLayoutManager);
        chatRv.setAdapter(chatActivityAdapter);
//        initChatUi();
        //底部布局弹出,聊天列表上滑
        chatRv.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (bottom < oldBottom) {
                    chatRv.post(new Runnable() {
                        @Override
                        public void run() {
                            if (chatActivityAdapter.getItemCount() > 0) {
                                chatRv.scrollToPosition(chatActivityAdapter.getItemCount() - 1);
                            }
                        }
                    });
                }
            }
        });
//点击空白区域关闭键盘
        chatRv.setOnTouchListener((view, motionEvent) -> {
//                mUiHelper.hideBottomLayout(false);
//                mUiHelper.hideSoftInput();
            mInputManager.hideSoftInputFromWindow(chatEt.getWindowToken(), 0);
            chatBottom.clearFocus();
            return false;
        });

    }

    @Override
    protected void destroy() {

    }

    @OnClick({R.id.chat_back, R.id.chat_head, R.id.chat_more, R.id.chat_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.chat_back:
                finish();
                break;
            case R.id.chat_head:
                showToast("正在开发...");
                break;
            case R.id.chat_more:
                showToast("正在开发...");
                break;
            case R.id.chat_send:
                if (chatEt.getText().toString().isEmpty()) {
                    showToast("不能发送空消息");
                    return;
                }
                sendMsg(chatEt.getText().toString());
                chatEt.setText("");
                chatRv.scrollToPosition(chatActivityAdapter.getItemCount() - 1);
//                showToast("发送成功");
                break;
            default:
                break;
        }
    }

    private void sendMsg(String msg) {
        XHIMMessage message = XHClient.getInstance().getChatManager().sendMessage(msg, mTargetId, new IXHResultCallback() {
            @Override
            public void success(Object data) {
//                MLOC.d("IM_C2C  成功","消息序号："+data);
            }

            @Override
            public void failed(String errMsg) {
//                MLOC.d("IM_C2C  失败","消息序号："+errMsg);
            }
        });
        MsgBean messageBean = new MsgBean();
        messageBean.setConversationId(message.targetId);
        messageBean.setTime(new SimpleDateFormat("MM-dd HH:mm").format(new java.util.Date()));
        messageBean.setMsg(message.contentData);
        messageBean.setFromId(message.fromId);
        ObjectBox.addMessageToDB(messageBean);
        chatActivityAdapter.addData(messageBean);
    }

    private void addListener() {
        AEvent.addListener(AEvent.AEVENT_C2C_REV_MSG, this);
        AEvent.addListener(AEvent.AEVENT_REV_SYSTEM_MSG, this);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        addListener();
//        List<MsgBean> list = ObjectBox.getMessageList(mTargetId);
//        if (list != null && list.size() > 0) {
//            chatActivityAdapter.addData(chatActivityAdapter.getItemCount()-1,list);
//        }
//        chatRv.scrollToPosition(chatActivityAdapter.getItemCount() - 1);
    }

    @Override
    public void onResume() {
        super.onResume();
        addListener();
    }

    @Override
    public void dispatchEvent(String aEventID, boolean success, final Object eventObj) {
//        MLOC.d("IM_C2C",aEventID+"||"+eventObj);
        switch (aEventID) {
            case AEvent.AEVENT_C2C_REV_MSG:
            case AEvent.AEVENT_REV_SYSTEM_MSG:
                final XHIMMessage revMsg = (XHIMMessage) eventObj;
                if (revMsg.fromId.equals(mTargetId)) {
                    MsgBean messageBean = new MsgBean();
                    Log.d("ljy", "dispatchEvent: " + messageBean);
                    messageBean.setConversationId(revMsg.fromId);
                    messageBean.setTime(new SimpleDateFormat("MM-dd HH:mm").format(new java.util.Date()));
                    messageBean.setMsg(revMsg.contentData);
                    messageBean.setFromId(revMsg.fromId);
                    chatActivityAdapter.addData(chatActivityAdapter.getItemCount(), messageBean);
                    chatRv.scrollToPosition(chatActivityAdapter.getItemCount() - 1);
                }
                break;
            default:
                break;
        }
    }

}
