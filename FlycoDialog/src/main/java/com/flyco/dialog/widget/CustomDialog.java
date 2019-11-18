package com.flyco.dialog.widget;

import android.content.Context;
import android.view.View;

import com.flyco.dialog.widget.base.BaseDialog;

public class CustomDialog extends BaseDialog<CustomDialog> {

    private View mInflate;

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, View view) {
        super(context);
        mInflate = view;
    }

    public CustomDialog(Context context, View view, boolean isPopupStyle){
        super(context, isPopupStyle);
        mInflate = view;
    }

    @Override
    public View onCreateView() {
        return mInflate;
    }

    @Override
    public void setUiBeforShow() {

    }
}
