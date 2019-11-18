package com.flyco.dialog.widget.popup;

import android.content.Context;
import android.view.View;

import com.flyco.dialog.widget.popup.base.BasePopup;

/**
 * Version V_1.0
 * Created by twp on 2017/11/16.
 * Recompose by twp on 2017/11/16.
 */

public class CustomPopup extends BasePopup<CustomPopup> {

    public CustomPopup(Context context, View wrappedView) {
        super(context, wrappedView);
    }

    @Override
    public View onCreatePopupView() {
        return null;
    }

    @Override
    public void setUiBeforShow() {

    }



}