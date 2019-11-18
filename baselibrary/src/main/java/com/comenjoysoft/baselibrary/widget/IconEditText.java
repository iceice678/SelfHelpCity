package com.comenjoysoft.baselibrary.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.comenjoysoft.baselibrary.R;


/**
 * Version V_1.0
 *
 * @author twp
 * @date 2017/9/20
 * Recompose by twp on 2017/9/20.
 */

public class IconEditText extends FrameLayout implements TextWatcher, View.OnClickListener {

    private final boolean mLeftIconShow;
    private final boolean mRightIconShow;
    private final ImageView mLeft;
    private final ImageView mRight;
    private final EditText mEditText;
    private final int mLeftIcon;
    private final int mRightIcon;
    private String mInputText;
    private boolean isShowPassword = false;
    private final int mMaxLength;
    private final ConstraintLayout cl_title;

    public IconEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.IconEditText, 0, 0);
//        /* 标题属性 */
        String text = typedArray.getString(R.styleable.IconEditText_text);
        int textColor = typedArray.getColor(R.styleable.IconEditText_textColor, Color.BLACK);
        float textSize = typedArray.getDimensionPixelSize(R.styleable.IconEditText_textSize, 16);
        String hint = typedArray.getString(R.styleable.IconEditText_hint);

        mLeftIcon = typedArray.getResourceId(R.styleable.IconEditText_editLeftIcon, -1);
        mRightIcon = typedArray.getResourceId(R.styleable.IconEditText_editRightIcon, -1);
        mLeftIconShow = typedArray.getBoolean(R.styleable.IconEditText_leftIconShow, false);
        mRightIconShow = typedArray.getBoolean(R.styleable.IconEditText_rightIconShow, false);
        int inputType = typedArray.getInteger(R.styleable.IconEditText_inputType, InputType.TYPE_CLASS_TEXT);
        mMaxLength = typedArray.getInteger(R.styleable.IconEditText_maxLength, 100);

        int frameType = typedArray.getInteger(R.styleable.IconEditText_frameType, InputType.TYPE_CLASS_TEXT);
        int frameColor = typedArray.getColor(R.styleable.IconEditText_frameColor, Color.BLACK);
        float frameSize = typedArray.getDimensionPixelSize(R.styleable.IconEditText_frameSize, 1);

        typedArray.recycle();
        LayoutInflater.from(context).inflate(R.layout.view_icon_edit_view, this);

        cl_title = findViewById(R.id.cl_title);
        mLeft = findViewById(R.id.left);
        mRight = findViewById(R.id.right);
        mEditText = findViewById(R.id.text);
        if (inputType < 128) {
            mEditText.setInputType(inputType);
        } else if (inputType < 144) {
            //密码显示*号
            mEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
        } else {
            //密码可见
            mEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD | InputType.TYPE_CLASS_TEXT);
        }
        if (text != null) {
            mEditText.setText(text);
            mEditText.setSelection(text.length());
        }
        mEditText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mEditText.setTextColor(textColor);
        mEditText.setTextSize(textSize);
        mEditText.setHint(hint);

        if (mLeftIcon != -1) {
            mLeft.setImageResource(mLeftIcon);
        } else {
            mLeft.setVisibility(GONE);
        }
        if (mRightIcon != -1) {
            mRight.setImageResource(mRightIcon);
            if (text == null || text.length() == 0) {
                mRight.setVisibility(INVISIBLE);
//                if (mEditText.getInputType() < 128) {//文本
//                    mRight.setVisibility(INVISIBLE);
//                }
            }
        } else {
            mRight.setVisibility(INVISIBLE);
        }
        mEditText.addTextChangedListener(this);
        mRight.setOnClickListener(this);
    }

    public String getText() {
        return mEditText.getText().toString();
    }

    public void setEditText(CharSequence text) {
        mEditText.setText(text);
        mEditText.setSelection(text.length());//将光标移至文字末尾
    }

    public void setEditTextHint(CharSequence text) {
        mEditText.setHint(text);
    }

    public void setEditTextHint(int resId) {
        mEditText.setHint(resId);
    }

    public void setEditText(int resid) {
        mEditText.setText(resid);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        mEditText.addTextChangedListener(textWatcher);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        mEditText.setSingleLine(true);
        mEditText.setOnEditorActionListener(onEditorActionListener);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        mInputText = charSequence.toString();
        if (mRightIcon != -1 && charSequence.length() > 0) {
            mRight.setVisibility(VISIBLE);
        } else {
            mRight.setVisibility(INVISIBLE);
        }
//        else if (mEditText.getInputType() < 128) {
//            mRight.setVisibility(INVISIBLE);
//        }
        if (charSequence.length() > mMaxLength) {
            mEditText.setText(charSequence.toString().substring(0, mMaxLength));
            mEditText.setSelection(mMaxLength);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }


    @Override
    public void onClick(View view) {
        mEditText.setText("");
//        if (mEditText.getInputType() < 128) {//文本
//            mEditText.setText("");
//        } else if (mEditText.getInputType() >= 128 && mEditText.getInputType() < 144) {
//            //密码*号显示
////            mRight.setImageResource(R.drawable.ic_no_show_password);
//            mEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD | InputType.TYPE_CLASS_TEXT);
//            mEditText.setText(mInputText);
//            mEditText.setSelection(mInputText.length());
//        } else if (mEditText.getInputType() > 144) {
//            //密码明码显示
////            mRight.setImageResource(R.drawable.ic_show_password);
//            mEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
//            mEditText.setText(mInputText);
//            mEditText.setSelection(mInputText.length());
//        }
    }

    /**
     * 将dip或dp值转换为px值
     *
     * @param dipValue dp值
     * @return
     */
    public static int dip2px(float dipValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public void setOnclicked(Boolean onclicked) {
        mEditText.setClickable(onclicked);
        mEditText.setEnabled(onclicked);
        mEditText.setFocusable(onclicked);
    }


}

