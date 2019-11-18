package com.example.selfhelpcity.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class FeedBackActivity extends BaseActivity {
    @BindView(R.id.feedback_back)
    ImageView feedbackBack;
    @BindView(R.id.feedback_title)
    TextView feedbackTitle;

    @Override
    protected int getContentView() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void init(Bundle bundle) {
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void destroy() {
    }


    @OnClick({R.id.feedback_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                finish();
                break;
          default:
                break;
        }
    }
}
