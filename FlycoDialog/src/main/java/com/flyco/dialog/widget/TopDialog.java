package com.flyco.dialog.widget;

import android.content.Context;
import android.view.View;

import com.flyco.dialog.widget.popup.base.BasePopup;

public class TopDialog extends BasePopup<TopDialog> {
    private View mInflate;

    public TopDialog(Context context, View view) {
        super(context, view);
    }

    @Override
    public View onCreatePopupView() {
        return null;
    }

    public TopDialog(Context context) {
        super(context);
    }

    @Override
    public void setUiBeforShow() {

    }

}
