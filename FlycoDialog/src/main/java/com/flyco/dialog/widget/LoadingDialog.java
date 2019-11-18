package com.flyco.dialog.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.dialog.R;


/**
 * Author ： DemonJang
 * Data ： 2017/1/18
 * Dec ：description
 */

public class LoadingDialog {
    /**
     * 得到自定义的progressDialog
     *
     * @param context
     * @param msg
     * @return
     */
    public static Dialog createLoadingDialog(Context context, String msg) {

        // 首先得到整个View
        View view = LayoutInflater.from(context).inflate(R.layout.layout_loading_dialog, null);
        // 获取整个布局
        LinearLayout layout = view.findViewById(R.id.linear_dialog);
        // 页面中的Img
        ImageView image = view.findViewById(R.id.image_dialog);
        // 页面中显示文本
        TextView text = view.findViewById(R.id.text_dialog);

        // 加载动画，动画用户使img图片不停的旋转
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.dialog_load_animation);
        // 显示动画
        image.startAnimation(animation);
        // 显示文本
        text.setText(msg);

        // 创建自定义样式的Dialog
        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);
        loadingDialog.setCanceledOnTouchOutside(false);
        // 设置返回键无效
        loadingDialog.setCancelable(false);
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        loadingDialog.show();
        return loadingDialog;
    }
}
