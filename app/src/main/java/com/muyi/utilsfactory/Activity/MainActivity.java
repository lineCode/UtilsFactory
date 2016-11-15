package com.muyi.utilsfactory.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.muyi.utilsfactory.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static android.R.attr.id;


/**
 * Author:  Miuky
 * Time:    2016.11.11
 * Title:   MainActivity
 * Desc:    App's Entrance Class
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mLvItemName;
    private List<Map<String, Object>> listItemNames;
    private Map<String, Object> mItemInfoMap;
    private final ThreadLocal<String[]> mItemNamesArray = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{
                    MainActivity.this.getResources().getString(R.string.item_name_00),
                    MainActivity.this.getResources().getString(R.string.item_name_01),
                    MainActivity.this.getResources().getString(R.string.item_name_02),
                    MainActivity.this.getResources().getString(R.string.item_name_03),
                    MainActivity.this.getResources().getString(R.string.item_name_04),
                    MainActivity.this.getResources().getString(R.string.item_name_05),
                    MainActivity.this.getResources().getString(R.string.item_name_06),
                    MainActivity.this.getResources().getString(R.string.item_name_07),
                    MainActivity.this.getResources().getString(R.string.item_name_08),
                    MainActivity.this.getResources().getString(R.string.item_name_09),
                    MainActivity.this.getResources().getString(R.string.item_name_10),
                    MainActivity.this.getResources().getString(R.string.item_name_11),
                    MainActivity.this.getResources().getString(R.string.item_name_12),
                    MainActivity.this.getResources().getString(R.string.item_name_13),
                    MainActivity.this.getResources().getString(R.string.item_name_14),
                    MainActivity.this.getResources().getString(R.string.item_name_15),
                    MainActivity.this.getResources().getString(R.string.item_name_16),
                    MainActivity.this.getResources().getString(R.string.item_name_17),
                    MainActivity.this.getResources().getString(R.string.item_name_18),
                    MainActivity.this.getResources().getString(R.string.item_name_19),
                    MainActivity.this.getResources().getString(R.string.item_name_20)

            };
        }
    };
    private final ThreadLocal<String[]> mItemIntroduceInfoArray = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{
                    MainActivity.this.getResources().getString(R.string.item_introduce_00),
                    MainActivity.this.getResources().getString(R.string.item_introduce_01),
                    MainActivity.this.getResources().getString(R.string.item_introduce_02),
                    MainActivity.this.getResources().getString(R.string.item_introduce_03),
                    MainActivity.this.getResources().getString(R.string.item_introduce_04),
                    MainActivity.this.getResources().getString(R.string.item_introduce_05),
                    MainActivity.this.getResources().getString(R.string.item_introduce_06),
                    MainActivity.this.getResources().getString(R.string.item_introduce_07),
                    MainActivity.this.getResources().getString(R.string.item_introduce_08),
                    MainActivity.this.getResources().getString(R.string.item_introduce_09),
                    MainActivity.this.getResources().getString(R.string.item_introduce_10),
                    MainActivity.this.getResources().getString(R.string.item_introduce_11),
                    MainActivity.this.getResources().getString(R.string.item_introduce_12),
                    MainActivity.this.getResources().getString(R.string.item_introduce_13),
                    MainActivity.this.getResources().getString(R.string.item_introduce_14),
                    MainActivity.this.getResources().getString(R.string.item_introduce_15),
                    MainActivity.this.getResources().getString(R.string.item_introduce_16),
                    MainActivity.this.getResources().getString(R.string.item_introduce_17),
                    MainActivity.this.getResources().getString(R.string.item_introduce_18),
                    MainActivity.this.getResources().getString(R.string.item_introduce_19),
                    MainActivity.this.getResources().getString(R.string.item_introduce_20),


            };
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initView() {
        mLvItemName = (ListView) findViewById(R.id.lv_item_name);
    }

    private void initData() {

        //ListView set Data Adapter
        mLvItemName.setAdapter(new listViewAdapter(this));
        //Set ListView's Item Click Listener
        mLvItemName.setOnItemClickListener(this);
        listItemNames = getListItems();
    }

    /**
     * 初始化商品信息
     */
    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < mItemNamesArray.get().length; i++) {
            mItemInfoMap = new HashMap<>();
            mItemInfoMap.put("title", mItemNamesArray.get()[i]);
            mItemInfoMap.put("introduce", mItemIntroduceInfoArray.get()[i]);
            listItems.add(mItemInfoMap);

        }
        return listItems;
    }

    /**
     * ListView's Item Click Logic
     *
     * @param adapterView s
     * @param view        s
     * @param position    s
     * @param l           s
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent;
        switch (position) {
            case 0://Activity
                Toast.makeText(this, "You Have Chose : Activity-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 1://Fragment
                Toast.makeText(this, "You Have Chose : Fragment-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 2://Application
                Toast.makeText(this, "You Have Chose : Application-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 3://硬件设备
                Toast.makeText(this, "You Have Chose : 硬件设备-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 4://数据存储
                Toast.makeText(this, "You Have Chose : 数据存储-Item" + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 5://编码安全
                Toast.makeText(this, "You Have Chose : 编码安全-Item" + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 6://数值转换
                Toast.makeText(this, "You Have Chose : 数值转换-Item" + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 7://网络
                Toast.makeText(this, "You Have Chose : 网络-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 8://图片
                Toast.makeText(this, "You Have Chose : 图片-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 9://文本
                intent = new Intent(MainActivity.this, TextActivity.class);
                startActivity(intent);
                Toast.makeText(this, "You Have Chose : 文本-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 10://通知
                Toast.makeText(this, "You Have Chose : 通知-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 11://日志工具
                intent = new Intent(MainActivity.this, LogToolActivity.class);
                startActivity(intent);
                Toast.makeText(this, "You Have Chose : 日志工具-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 12://日期
                Toast.makeText(this, "You Have Chose : 日期-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 13://定位
                Toast.makeText(this, "You Have Chose : 定位-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 14://5.0以上权限获取
                Toast.makeText(this, "You Have Chose : 5.0以上权限获取-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 15://ViewGroup && Adapter
                Toast.makeText(this, "You Have Chose : ViewGroup&&Adapter--Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 16://自定义控件
                Toast.makeText(this, "You Have Chose : 自定义控件-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 17://键盘输入
                Toast.makeText(this, "You Have Chose : 键盘输入-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 18://屏幕参数 && 适配
                Toast.makeText(this, "You Have Chose : 屏幕参数 && 适配-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 19://线程
                Toast.makeText(this, "You Have Chose : 线程-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 20://相机
                Toast.makeText(this, "You Have Chose : 相机-Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 21:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
        }

    }

    /**
     * ListView's Adapter
     */
    public class listViewAdapter extends BaseAdapter {

        //LayoutInflater Object Initialization
        //布局填充器对象初始化
        private LayoutInflater mInflater = null;

        private listViewAdapter(Context context) {
            //Load layout base on Context
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mItemNamesArray.get().length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_main_activity_listview, null);
                holder.title = (TextView) convertView.findViewById(R.id.tv_item_name);
                holder.introduction = (TextView) convertView.findViewById(R.id.tv_introduceInfo);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(position + 1 + "、" + listItemNames.get(position).get("title").toString());
            holder.introduction.setText(getResources().getString(R.string.introduction)+"\n        " + listItemNames.get(position).get("introduce").toString());
            return convertView;
        }
    }

    /**
     * ViewHolder Static Class
     */
    static class ViewHolder {
        TextView title;
        TextView introduction;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Toast.makeText(this,"您点击了关于这个按钮",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
