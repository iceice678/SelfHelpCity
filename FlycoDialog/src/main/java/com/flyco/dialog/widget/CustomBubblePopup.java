package com.flyco.dialog.widget;

import android.content.Context;
import android.view.View;

import com.flyco.dialog.widget.popup.base.BaseBubblePopup;

/**
 * @author android-admin
 */
public class CustomBubblePopup extends BaseBubblePopup<CustomBubblePopup> {


    public CustomBubblePopup(Context context, View wrappedView) {
        super(context, wrappedView);
//        super.setUiBeforShow();
    }

    @Override
    public View onCreateBubbleView() {
        return null;
    }

    @Override
    public void setUiBeforShow() {
        super.setUiBeforShow();
    }
}
