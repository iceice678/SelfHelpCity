package com.comenjoysoft.baselibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.comenjoysoft.baselibrary.R;

public class CustomToolbar extends FrameLayout {

    private Context context;
    private Toolbar toolbar;
    private TextView tvTitle;
    private boolean titleCenter;

    public CustomToolbar(Context context) {
        super(context);
        this.context = context;
        initView(context);
    }

    public CustomToolbar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
        initAttrs(context, attrs);
    }

    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
        initAttrs(context, attrs);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_toolbar, this);
        toolbar = findViewById(R.id.custom_toolbar);
        tvTitle = findViewById(R.id.tv_title);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar);

        titleCenter = typedArray.getBoolean(R.styleable.CustomToolbar_titleCenter, false);
        setTitleCenter(titleCenter);

        String title = typedArray.getString(R.styleable.CustomToolbar_title);
        int titleColor = typedArray.getColor(R.styleable.CustomToolbar_titleColor, Color.BLACK);
        float titleSize = typedArray.getInteger(R.styleable.CustomToolbar_titleSize, 20);
        setTitle(title);
        setTitleColor(titleColor);
        setTitleSize(titleSize);

        int navigationIcon = typedArray.getResourceId(R.styleable.CustomToolbar_navigationIcon, -1);
        setNavigationIcon(navigationIcon);

        typedArray.recycle();
    }

    /**
     * 标题是否居中
     *
     * @param isCenter
     */
    public void setTitleCenter(boolean isCenter) {
        if (isCenter) {
            tvTitle.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 设置标题文字
     *
     * @param title
     */
    public void setTitle(String title) {
        if (titleCenter) {
            tvTitle.setText(title);
        } else {
            toolbar.setTitle(title);
        }
    }

    public void setTitleColor(int color) {
        if (titleCenter) {
            tvTitle.setTextColor(color);
        } else {
            toolbar.setTitleTextColor(color);
        }
    }

    public void setTitleSize(float size) {
        if (titleCenter) {
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
//        else {
//            toolbar.setTitleTextAppearance(context,size);
//        }
    }

    public void setNavigationIcon(int resId) {
        toolbar.setNavigationIcon(resId);
    }

    public void setNavigationOnClickListener(OnClickListener listener) {
        toolbar.setNavigationOnClickListener(listener);
    }
}
