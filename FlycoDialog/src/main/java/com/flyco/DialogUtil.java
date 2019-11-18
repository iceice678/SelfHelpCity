package com.flyco;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.flyco.animation.BaseAnimatorSet;
import com.flyco.animation.SlideEnter.SlideTopEnter;
import com.flyco.animation.SlideExit.SlideTopExit;
import com.flyco.dialog.R;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.CustomDialog;
import com.flyco.dialog.widget.LoadingDialog;
import com.flyco.dialog.widget.MaterialDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.flyco.dialog.widget.NormalListDialog;
import com.flyco.dialog.widget.TopDialog;
import com.flyco.dialog.widget.popup.BubblePopup;
import com.flyco.dialog.widget.popup.CustomPopup;

/**
 * Version V_1.0
 * Created by twp on 2017/9/29.
 * Recompose by twp on 2017/9/29.
 */

public class DialogUtil {

    public static DialogUtil mDialogUtil;
    private static Context mContext;

    public static BaseAnimatorSet mBasIn;
    public static BaseAnimatorSet mBasOut;

    public DialogUtil(Context context) {

    }

    public static DialogUtil getInstance(Context context) {
        mContext = context;
        if (mDialogUtil == null) {
            mDialogUtil = new DialogUtil(context);
        }
        return mDialogUtil;
    }

    static void setBasIn(BaseAnimatorSet bas_in) {
        mBasIn = bas_in;
    }

    static void setBasOut(BaseAnimatorSet bas_out) {
        mBasOut = bas_out;
    }

    /**
     * 标题和内容左对齐,两个按钮
     *
     * @param title
     * @param msg
     * @param btnClickL
     * @param btnClickR
     */
    public void normalDialogTwo(String title, String msg, String leftTxt, String rightTxt, int leftColor, int rightColor, OnBtnClickL btnClickL, OnBtnClickL btnClickR) {
        final NormalDialog dialog = new NormalDialog(mContext);
        dialog.title(title)
                .content(msg)
                .btnText(leftTxt, rightTxt)
                .btnTextColor(leftColor, rightColor)
                .showAnim(mBasIn)
                .dismissAnim(mBasOut)
                .show();
        dialog.setOnBtnClickL(btnClickL, btnClickR);
    }

    /**
     * 标题和内容居中对齐,两个按钮
     *
     * @param title
     * @param msg
     * @param btnClickL
     * @param btnClickR
     */
    public NormalDialog normalDialogStyleTwo(String title, String msg, int titleTextColor, int msgColor, int leftTxtColor, int rightTxtColor, final OnBtnClickL btnClickL, OnBtnClickL btnClickR) {
        final NormalDialog dialog = new NormalDialog(mContext);
        dialog.content(msg)
                .title(title)
                .titleTextColor(titleTextColor)
                .contentTextColor(msgColor)
                .btnTextColor(leftTxtColor, rightTxtColor)
//                .titleLineColor(Color.parseColor("#222222"))
//                .titleLineHeight(1)
//                .titleLineShow(true)
                .style(NormalDialog.STYLE_TWO)
//                .titleTextSize(23)
                .showAnim(mBasIn)
                .dismissAnim(mBasOut)
                .show();
        dialog.setOnBtnClickL(btnClickL, btnClickR);
        return dialog;
    }

    /**
     * 背景灰色,没有标题,两个按钮
     *
     * @param title
     * @param msg
     * @param leftListener
     * @param rightListener
     */
    public void normalDialogCustomAttr(String title, String msg, OnBtnClickL leftListener, OnBtnClickL rightListener) {
        final NormalDialog dialog = new NormalDialog(mContext);
        dialog.isTitleShow(true)
                .title(title).titleTextColor(Color.parseColor("#FFFFFF"))
                .titleTextColor(Color.parseColor("#FFFFFF"))
                .titleLineShow(false)
                .bgColor(Color.parseColor("#383838"))
                .cornerRadius(5)
                .content(msg)
                .contentGravity(Gravity.CENTER)
                .contentTextColor(Color.parseColor("#ffffff"))
                .dividerColor(Color.parseColor("#222222"))
                .btnTextSize(15.5f, 15.5f)
                .btnTextColor(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"))
                .btnPressColor(Color.parseColor("#2B2B2B"))
                .widthScale(0.85f)
                .showAnim(mBasIn)
                .dismissAnim(mBasOut)
                .show();
        dialog.setOnBtnClickL(leftListener, rightListener);
    }

    /**
     * 标题和内容左对齐,一个按钮
     *
     * @param title
     * @param msg
     * @param btnText
     * @param listener
     */
    public void normalDialogOneBtn(String title, String msg, String btnText, OnBtnClickL listener) {
        final NormalDialog dialog = new NormalDialog(mContext);
        dialog.title(title)
                .content(msg)
                .btnNum(1)
                .btnText(btnText)
                .showAnim(mBasIn)
                .dismissAnim(mBasOut)
                .show();

        dialog.setOnBtnClickL(listener);
    }

    /**
     * 标题和内容居中,三个按钮
     *
     * @param title
     * @param msg
     */
    public void normalDialoThreeBtn(String title, String msg, OnBtnClickL leftBtn, OnBtnClickL middleBtn, OnBtnClickL rightBtn) {
        final NormalDialog dialog = new NormalDialog(mContext);
        dialog.title(title)
                .content(msg)//
                .style(NormalDialog.STYLE_TWO)
                .btnNum(3)
                .btnText("取消", "确定", "继续逛逛")
                .showAnim(mBasIn)//
                .dismissAnim(mBasOut)//
                .show();

        dialog.setOnBtnClickL(leftBtn, rightBtn, middleBtn);
    }


    /**
     * 背景灰色,有标题,系统默认按钮,内容标题左对齐
     *
     * @param title
     * @param msg
     * @param leftText
     * @param rightText
     * @param leftBtn
     * @param rightBtn
     */
    public MaterialDialog materialDialogDefault(String title, String msg, String leftText, String rightText, OnBtnClickL leftBtn, OnBtnClickL rightBtn) {
        final MaterialDialog dialog = new MaterialDialog(mContext);
        dialog.setOnBtnClickL(leftBtn, rightBtn);
        dialog.title(title)
                .titleTextColor(Color.parseColor("#000000"))
                .titleTextSize(15f)
                .content(msg)
                .btnText(leftText, rightText)
                .contentTextSize(15f)
                .contentTextColor(Color.parseColor("#000000"))
                .btnTextColor(Color.parseColor("#000000"), Color.parseColor("#000000"))
                .btnTextSize(14f)
                .showAnim(mBasIn)
                .bgColor(Color.parseColor("#ffffff"))
                .dismissAnim(mBasOut)
                .show();
        return dialog;
    }


    /**
     * 背景灰色,没有标题,系统默认按钮,内容左对齐
     *
     * @param msg
     * @param leftText
     * @param rightText
     * @param leftBtn
     * @param rightBtn
     */
    public MaterialDialog materialDialogDefault(String msg, String leftText, String rightText, OnBtnClickL leftBtn, OnBtnClickL rightBtn) {
        final MaterialDialog dialog = new MaterialDialog(mContext);
        dialog.setOnBtnClickL(leftBtn, rightBtn);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.content(msg)
                .btnText(leftText, rightText)
                .contentTextSize(16f)
                .contentTextColor(Color.parseColor("#000000"))
                .btnTextColor(Color.parseColor("#000000"), Color.parseColor("#000000"))
                .btnTextSize(14f)
                .titleTextColor(Color.parseColor("#000000"))
                .bgColor(Color.parseColor("#ffffff"))
                .showAnim(mBasIn)
                .dismissAnim(mBasOut)
                .show();
        ;
        return dialog;
    }


    public void materialDialogThreeBtns() {
        final MaterialDialog dialog = new MaterialDialog(mContext);
        dialog.isTitleShow(false)//
                .btnNum(3)
                .content("为保证咖啡豆的新鲜度和咖啡的香味，并配以特有的传统烘焙和手工冲。")//
                .btnText("确定", "取消", "知道了")//
                .showAnim(mBasIn)//
                .dismissAnim(mBasOut)//
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {//left btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {//right btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                    }
                }
                ,
                new OnBtnClickL() {//middle btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                    }
                }
        );
    }

    public void materialDialogOneBtn(String title, String msg, OnBtnClickL rightBtn) {
        final MaterialDialog dialog = new MaterialDialog(mContext);
        dialog.setOnBtnClickL(rightBtn);
        dialog.title(title)
                .titleTextSize(20f)
                .btnNum(1)
                .content(msg)
                .btnText("我知道了")
                .bgColor(Color.parseColor("#ffffff"))
                .btnTextColor(Color.parseColor("#545476"))
                .showAnim(mBasIn)//
                .dismissAnim(mBasOut)
                .show();
    }

    public void normalListDialog(String[] mMenuItems, OnOperItemClickL itemClickL) {
        final NormalListDialog dialog = new NormalListDialog(mContext, mMenuItems);
        dialog.title("请选择")//
                .showAnim(mBasIn)//
                .dismissAnim(mBasOut)//
                .show();
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
            }
        });
    }


    public void normalListDialogCustomAttr(String[] mMenuItems, OnOperItemClickL itemClickL) {
        final NormalListDialog dialog = new NormalListDialog(mContext, mMenuItems);
        dialog.title("请选择")
                .titleTextSize_SP(18)
                .titleBgColor(Color.parseColor("#409ED7"))
                .itemPressColor(R.color.FlycoDialog_colorAccent)
                .itemTextColor(Color.parseColor("#303030"))
                .itemTextSize(14)
                .cornerRadius(0)
                .widthScale(0.8f)
                .show(R.style.FlycoDialog_myDialogAnim);

        dialog.setOnOperItemClickL(itemClickL);
    }


    public void normalListDialogNoTitle(String[] mMenuItems) {
        final NormalListDialog dialog = new NormalListDialog(mContext, mMenuItems);
        dialog.title("请选择")
                .isTitleShow(false)
                .itemPressColor(Color.parseColor("#85D3EF"))
                .itemTextColor(Color.parseColor("#303030"))
                .itemTextSize(15)
                .cornerRadius(2)
                .widthScale(0.75f)
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
            }
        });
    }

    public void normalListDialogStringArr(String[] mStringItems, final OnOperItemClickL clickL) {
        final NormalListDialog dialog = new NormalListDialog(mContext, mStringItems);
        dialog.title("请选择")
//                .isTitleShow(false)
                .layoutAnimation(null)
                .autoDismiss(false)
                .widthScale(0.5f)
                .heightScale(0.5f)
                .setItemExtraPadding(20, 10, 20, 10)
                .itemTextSize(20f)
                .titleTextSize_SP(22f)
                .titleBgColor(Color.parseColor("#4d80fc"))
                .titleTextColor(Color.parseColor("#ffffff"))
                .show(R.style.FlycoDialog_myDialogAnim);
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickL.onOperItemClick(parent, view, position, id);
                dialog.dismiss();
            }
        });
    }

    public void normalListDialogAdapter(BaseAdapter adapter) {
        final NormalListDialog dialog = new NormalListDialog(mContext, adapter);
        dialog.title("请选择")
                .show(R.style.FlycoDialog_myDialogAnim);
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
            }
        });
    }

    public void actionSheetDialog(String[] items, OnOperItemClickL itemClick) {
//        final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
        final ActionSheetDialog dialog = new ActionSheetDialog(mContext, items, null);
        dialog.isTitleShow(false)
                .itemHeight(50)
                .titleTextSize_SP(14.5f)
                .layoutAnimation(null)
                .itemTextColor(Color.parseColor("#000000"))
                .cancelTextColor(Color.parseColor("#000000"))
                .lvBgColor(Color.parseColor("#ffffff"))
                .show();
        dialog.setOnOperItemClickL(itemClick);
    }

    public void actionSheetDialog(String title, String[] items) {
//        final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
        final ActionSheetDialog dialog = new ActionSheetDialog(mContext, items, null);
        dialog.title(title)
                .titleTextSize_SP(14.5f)
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
            }
        });
    }

    public void actionSheetDialogNoTitle(String[] stringItems, View animateView) {
//        final String[] stringItems = {"版本更新", "帮助与反馈", "退出QQ"};
        final ActionSheetDialog dialog = new ActionSheetDialog(mContext, stringItems, animateView);
        dialog.isTitleShow(false).show();
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
            }
        });
    }

    public void topDialog(View view, View centerView) {
        TopDialog topDialog = new TopDialog(mContext, view);
        topDialog.alignCenter(true)
                .anchorView(centerView)
                .gravity(Gravity.BOTTOM)
                .showAnim(new SlideTopEnter())
                .dismissAnim(new SlideTopExit())
                .offset(0, 0)
                .dimEnabled(true)
                .show();
//        topDialog.setUiBeforShow();
    }

    public BubblePopup bubblePopup(View view, View anchorView, int gravity) {
        BubblePopup customBubblePopup = new BubblePopup(mContext, view);
//        customBubblePopup.setCanceledOnTouchOutside(false);
        customBubblePopup
                .gravity(gravity)
                .anchorView(anchorView)
                .showAnim(null)
                .dismissAnim(null)
                .show();
        return customBubblePopup;
    }

    public CustomPopup customPopup(View view, View anchorView, int gravity) {
        CustomPopup customPopup = new CustomPopup(mContext, view);
        customPopup.alignCenter(true)
                .anchorView(anchorView)
                .offset(-10f, -30f)
                .gravity(gravity)
                .showAnim(null)
                .dismissAnim(null)
                .dimEnabled(false)
                .show();
        return customPopup;
    }

    public CustomPopup customPopup(View view, View anchorView) {
        CustomPopup customPopup = new CustomPopup(mContext, view);
        customPopup.alignCenter(true)
                .anchorView(anchorView)
                .offset(-10f, -30f)
                .gravity(Gravity.BOTTOM)
                .widthScale(0.85f)
                .showAnim(null)
                .dismissAnim(null)
                .dimEnabled(true)
                .show();
        return customPopup;
    }

    public CustomDialog customDialog(View view) {
        CustomDialog customDialog = new CustomDialog(mContext, view);
        customDialog.showAnim(null)
                .dismissAnim(null)
                .autoDismiss(false)
                .dimEnabled(true)
                .widthScale(0.52f)
                .show();

        return customDialog;
    }

    public CustomDialog customDialog(View view, boolean isPopupStyle) {
        CustomDialog customDialog = new CustomDialog(mContext, view, isPopupStyle);
        customDialog.showAnim(null)
                .dismissAnim(null)
                .show();
        return customDialog;
    }

    public Dialog loadingDialog(String msg) {
        return LoadingDialog.createLoadingDialog(mContext, msg);
    }
}
