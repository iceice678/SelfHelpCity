package com.example.selfhelpcity.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.selfhelpcity.R;
import com.example.selfhelpcity.adapter.ConstellationAdapter;
import com.example.selfhelpcity.adapter.GirdDropDownAdapter;
import com.example.selfhelpcity.adapter.ListDropDownAdapter;
import com.example.selfhelpcity.adapter.ReleaseAdapter;
import com.example.selfhelpcity.base.BaseActivity;
import com.example.selfhelpcity.bean.ReleaseBean;
import com.example.selfhelpcity.model.ObjectBox;
import com.example.selfhelpcity.util.KeyboardStateObserver;
import com.example.selfhelpcity.widget.DropDownMenu;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 首页
 */
public class MainActivity extends BaseActivity {
    private String headers[] = {"城市", "年龄", "性别", "星座"};
    private List<View> popupViews = new ArrayList<>();
    private GirdDropDownAdapter cityAdapter;
    private ListDropDownAdapter ageAdapter;
    private ListDropDownAdapter sexAdapter;
    private ConstellationAdapter constellationAdapter;
    private String citys[] = {"不限", "武汉", "北京", "上海", "成都", "广州", "深圳", "重庆", "天津", "西安", "南京", "杭州"};
    private String ages[] = {"不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上"};
    private String sexs[] = {"不限", "男", "女"};
    private String constellations[] = {"不限", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};

    private int constellationPosition = 0;

    @BindView(R.id.main_user)
    ImageView mainUser;
    @BindView(R.id.main_search)
    SearchView mainSearch;
    @BindView(R.id.main_msg)
    ImageView mainMsg;
    @BindView(R.id.main_navigationview)
    NavigationView mainNavigationview;
    @BindView(R.id.drawlayout)
    DrawerLayout drawlayout;
    @BindView(R.id.main_rv)
    RecyclerView mainRv;
    private List<ReleaseBean> list;
    private DropDownMenu mDropDownMenu;

    private ReleaseAdapter releaseAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle bundle) {

    }

    @Override
    protected void initView() {
        mDropDownMenu = findViewById(R.id.dropDownMenu);
        initDrop();
        NavigationView mainNavigationview = findViewById(R.id.main_navigationview);
        mainNavigationview.setItemIconTintList(null);
        mainSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showToast("提交");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        //获取头布局文件
        View headerView = mainNavigationview.getHeaderView(0);
        ImageView hedaImg = headerView.findViewById(R.id.menu_head);
        hedaImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, UserInfoActivity.class);
                startActivity(intent);
            }

        });
        mainNavigationview.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        KeyboardStateObserver.getKeyboardStateObserver(this).
                setKeyboardVisibilityListener(new KeyboardStateObserver.OnKeyboardVisibilityListener() {
                    @Override
                    public void onKeyboardShow() {
//                        Toast.makeText(MainActivity.this,"键盘弹出",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onKeyboardHide() {
                        mainSearch.clearFocus();
//                        Toast.makeText(MainActivity.this,"键盘收回",Toast.LENGTH_SHORT).show();
                    }
                });

        releaseAdapter = new ReleaseAdapter();
        mainRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainRv.setAdapter(releaseAdapter);
        releaseAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MainActivity.this, ReleaseInfoActivity.class).putExtra("targetId", "801139"));
            }
        });
    }

    @Override
    protected void initData() {
//        list = new ArrayList<>();
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        list.add(new ReleaseBean());
//        releaseAdapter.addData(list);
        releaseAdapter.setNewData(ObjectBox.getCommuityBeanBox().getAll());
    }

    @Override
    protected void destroy() {

    }

    @OnClick({R.id.main_user, R.id.main_msg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_user:
                drawlayout.openDrawer(mainNavigationview);
                break;
            case R.id.main_msg:
                startActivity(new Intent(MainActivity.this, AddReleaseActivity.class));
                break;
            default:
                break;
        }
    }

//    private void showPickerView() {// 弹出选择器
//
//        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
//            @Override
//            public void onOptionsSelect(int options1, int options2, int options3, View v) {
//                //返回的分别是三个级别的选中位置
//                String opt1tx = options1Items.size() > 0 ?
//                        options1Items.get(options1).getPickerViewText() : "";
//
//                String opt2tx = options2Items.size() > 0
//                        && options2Items.get(options1).size() > 0 ?
//                        options2Items.get(options1).get(options2) : "";
//
//                String opt3tx = options2Items.size() > 0
//                        && options3Items.get(options1).size() > 0
//                        && options3Items.get(options1).get(options2).size() > 0 ?
//                        options3Items.get(options1).get(options2).get(options3) : "";
//
//                String tx = opt1tx + opt2tx + opt3tx;
//                provinec = opt1tx;
//                city = opt2tx;
//                area = opt3tx;
//                tvUserAddressDQ.setText(tx);
//            }
//        })
//
//                .setTitleText("城市选择")
//                .setDividerColor(Color.BLACK)
//                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
//                .setContentTextSize(20)
//                .build();
//
//    /*pvOptions.setPicker(options1Items);//一级选择器
//    pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
//        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
//        pvOptions.show();
//    }

    private boolean onNavigationItemSelected(MenuItem menuItem) {
        Intent intent = new Intent();
        switch (menuItem.getItemId()) {
            case R.id.menu_release:
                intent.setClass(MainActivity.this, ReleaseActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_user:
                intent.setClass(MainActivity.this, UserInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_setting:
                intent.setClass(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_collection:
                intent.setClass(MainActivity.this, CollectionActivity.class);
                startActivity(intent);
                break;
//            case R.id.menu_feedback:
//                intent.setClass(MainActivity.this, FeedBackActivity.class);
//                startActivity(intent);
//                break;
            default:
                break;

        }
        return true;
    }


    private void initDrop() {
        //init city menu
        final ListView cityView = new ListView(this);
        cityAdapter = new GirdDropDownAdapter(this, Arrays.asList(citys));
        cityView.setDividerHeight(0);
        cityView.setAdapter(cityAdapter);

        //init age menu
        final ListView ageView = new ListView(this);
        ageView.setDividerHeight(0);
        ageAdapter = new ListDropDownAdapter(this, Arrays.asList(ages));
        ageView.setAdapter(ageAdapter);

        //init sex menu
        final ListView sexView = new ListView(this);
        sexView.setDividerHeight(0);
        sexAdapter = new ListDropDownAdapter(this, Arrays.asList(sexs));
        sexView.setAdapter(sexAdapter);

        //init constellation
        final View constellationView = getLayoutInflater().inflate(R.layout.custom_layout, null);
        GridView constellation = constellationView.findViewById(R.id.constellation);
        constellationAdapter = new ConstellationAdapter(this, Arrays.asList(constellations));
        constellation.setAdapter(constellationAdapter);
        TextView ok = constellationView.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDropDownMenu.setTabText(constellationPosition == 0 ? headers[3] : constellations[constellationPosition]);
                mDropDownMenu.closeMenu();
            }
        });

        //init popupViews
        popupViews.add(cityView);
        popupViews.add(ageView);
        popupViews.add(sexView);
        popupViews.add(constellationView);

        //add item click event
        cityView.setOnItemClickListener((parent, view, position, id) -> {
            cityAdapter.setCheckItem(position);
            mDropDownMenu.setTabText(position == 0 ? headers[0] : citys[position]);
            mDropDownMenu.closeMenu();
        });

        ageView.setOnItemClickListener((parent, view, position, id) -> {
            ageAdapter.setCheckItem(position);
            mDropDownMenu.setTabText(position == 0 ? headers[1] : ages[position]);
            mDropDownMenu.closeMenu();
        });

        sexView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            sexAdapter.setCheckItem(position);
            mDropDownMenu.setTabText(position == 0 ? headers[2] : sexs[position]);
            mDropDownMenu.closeMenu();
        });

        constellation.setOnItemClickListener((parent, view, position, id) -> {
            constellationAdapter.setCheckItem(position);
            constellationPosition = position;
        });

//        init contextview
        TextView contentView = new TextView(this);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        contentView.setText("内容显示区域");
        contentView.setGravity(Gravity.CENTER);
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        //init dropdownview
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, contentView);
    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}
