package com.example.selfhelpcity.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.comenjoysoft.baselibrary.util.SPUtils;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.base.BaseActivity;
import com.example.selfhelpcity.base.Constant;
import com.example.selfhelpcity.util.UriUtils;
import com.flyco.DialogUtil;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comenjoy.com.imageloadlibrary.GlideUtil;

/**
 * 个人信息界面
 */
public class UserInfoActivity extends BaseActivity {
    @BindView(R.id.userinfo_back)
    ImageView userinfoBack;
    @BindView(R.id.userinfo_title)
    TextView userinfoTitle;
    @BindView(R.id.au_head_portrait)
    ImageView auHeadPortrait;
    @BindView(R.id.au_username)
    EditText auUsername;
    @BindView(R.id.au_gender)
    TextView auGender;
    @BindView(R.id.au_phone_num)
    EditText auPhoneNum;
    @BindView(R.id.au_gender_ll)
    LinearLayout auGenderLl;

    private String[] sexArry = new String[]{"女", "男"};// 性别选择
    private int genderIndex;
    private static final int REQ_TAKE_PHOTO = 10001;
    private static final int REQ_SELECT_PHOTO = 10002;
    private static final int REQ_ZOOM_PHOTO = 10003;

    private File imgFile;

    @Override
    protected int getContentView() {
        return R.layout.activity_userinfo;
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

    @Override
    protected void onResume() {
        super.onResume();
        genderIndex = SPUtils.getInstance(getBaseContext()).getInt("checkGender");
    }

    @OnClick({R.id.userinfo_back, R.id.au_head_portrait, R.id.au_gender_ll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.userinfo_back:
                finish();
                break;
            case R.id.au_head_portrait:
                showSelectDialog();
                break;
            case R.id.au_gender_ll:
                showSexChooseDialog();
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQ_TAKE_PHOTO://拍照
                    if (imgFile.exists()) {
                        GlideUtil.getInstance().loadImage(this, imgFile.getPath(), R.mipmap.ic_default_avatar, auHeadPortrait);
                        SPUtils.getInstance(this).put(Constant.SP_KEY_HEADPORTRAIT, imgFile.getAbsolutePath());
//                        EventBus.getDefault().post(new MeInfoEvent<>(1201, imgFile.getAbsolutePath()));
                    }
                    break;
                case REQ_SELECT_PHOTO://图库
                    if (data != null) {
                        Uri sourceUri = data.getData();
                        if (sourceUri != null) {
                            imgFile = UriUtils.uri2File(getApplicationContext(), sourceUri);
                        } else {
                            showToast("选取照片失败");
                            return;
                        }
                        if (imgFile == null) {
                            return;
                        }
                        GlideUtil.getInstance().loadImage(this, imgFile.getPath(), R.mipmap.ic_default_avatar, auHeadPortrait);
//                        EventBus.getDefault().post(new MeInfoEvent<>(1201, imgFile.getPath()));
                        SPUtils.getInstance(this).put(Constant.SP_KEY_HEADPORTRAIT, imgFile.getPath());
                    }
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 性别选择框
     */
    private void showSexChooseDialog() {
        AlertDialog.Builder checkGender = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.checkGenderAlertDialog));// 自定义对话框
        // 2默认的选中
        checkGender.setSingleChoiceItems(sexArry, genderIndex, (dialog, which) -> {// which是被选中的位置
            // showToast(which+"");
            genderIndex = which;
            SPUtils.getInstance(this).put("checkGender", which);
            auGender.setText(sexArry[which]);
            dialog.dismiss();// 随便点击一个item消失对话框，不用点击确认取消
        });
        checkGender.show();// 让弹出框显示
    }

    private void showSelectDialog() {
        String[] items = {"拍照", "从相册选择"};
        DialogUtil.getInstance(this).actionSheetDialog(items, (AdapterView<?> parent, View view, int position, long id) -> {
//            if (position == 0) {
//               checkAppPermission(0);
//            } else if (position == 1) {
//              checkAppPermission(1);
//            } else {
//
//          }
            checkAppPermission(position);
        });
    }

    /**
     * 拍照获取
     */
    public void takePhoto() {
        String imgDri = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "DCIM" + File.separator;
        String name = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss", Locale.CHINESE).format(new Date()) + ".jpg";
        imgFile = new File(imgDri + name);
        if (!imgFile.getParentFile().exists()) {
            imgFile.getParentFile().mkdirs();
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, UriUtils.file2Uri(getApplicationContext(), imgFile));
        startActivityForResult(intent, REQ_TAKE_PHOTO);
    }

    /**
     * 从图库获取
     */
    public void selectPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, REQ_SELECT_PHOTO);
    }

    private void checkAppPermission(int i) {
        AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.STORAGE, Permission.Group.CAMERA)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (i == 0) {
                            takePhoto();
                        } else {
                            selectPhoto();
                        }
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {

                    }
                }).start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
