package com.example.selfhelpcity.base;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.comenjoysoft.baselibrary.model.iview.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected final String TAG = this.getClass().getSimpleName();

    /**
     * View点击
     **/
    protected abstract int getContentView();

    /**
     * 初始化
     */
    protected abstract void init(Bundle bundle);

    /**
     * 初始化控件
     */
    protected abstract void initView();

    protected abstract void initData();

    protected abstract void destroy();

    Unbinder unbinder;
    /**
     * activity堆栈管理
     */
    protected AppManager appManager = AppManager.getAppManager();

    private String contextString; // 类名

    /**
     * View点击
     **/
//    public abstract void widgetClick(View v);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //解决底部布局会被EditText挤出
        getWindow().setSoftInputMode
                (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN |
                        WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
//        setStatusBarColor(this);
        setContentView(getContentView());
        unbinder = ButterKnife.bind(this);
        appManager.addActivity(this);
        init(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {

//        appManager.finishActivity(this);
        destroy();
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarColor(AppCompatActivity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            //取消设置Window半透明的Flag
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //添加Flag把状态栏设为可绘制模式
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏为透明
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
