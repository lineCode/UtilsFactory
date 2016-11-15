package com.muyi.utilsfactory.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import java.util.Map;


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
    private String[] mItemNamesArray = {"Activity", "Fragment", "Application", "硬件设备", "数据存储",
            "编码安全", "数值转换", "网络", "图片", "文本", "通知",
            "日志工具", "日期", "定位", "5.0以上权限获取", "ViewGroup && Adapter", "自定义控件", "键盘输入",
            "屏幕参数 && 适配", "线程","相机"};
    private String[] mItemIntroduceInfoArray = {"包含了BaseActivity工具类以及一些遇见过的问题总结；", "包含了BaseFragemnt工具类以及一些遇见过的问题总结； "
            , "包含了继承了Application的自定义application工具类； ", "包含了各种硬件参数读取的工具代码； ", "包含了几种常见的数据存储方式的工具类代码，比如：SP、SQLite等； "
            , "包含了相关数据加密解密的方法以及基本知识的介绍； ", "包含了在开发过程中遇到的常见数值类型、单位等互相转换的工具类代码； ", "网络请求的基本封装以及json数据的解析工具类代码； "
            , "包含了图片的裁剪、旋转、基本动画、Gif图片播放等相关工具代码； ", "包含了对文本（TextView）排版、字体设置的工具类代码； ", "包含了吐司（Toast）、Dialog等工具类代码以及使用的方法介绍； "
            , "包含了日志生成、日志筛选、日志打印优化等工具类；", "包含了多种格式的日期或时间的格式化工具类； ", "包含使用设备自带GPS、Google地图、高德地图、百度地图基本的定位功能工具类以及使用方法介绍； "
            , "包含了Android5.0以后的应用首次打开的检测和获取权限相关工具类代码； ", "包含了趋向万能的Adapter、多种重写的Layout基类等工具类代码； ", "包含了Button等多种控件的自定义工具类代码； "
            , "包含了键盘在使用时遇到的隐藏、显示、遮挡问题解决方法代码； ", "包含了获取屏幕的多种参数和不同屏幕不同分辨率下的适配问题解决方法代码；； ", "包含了线程池和线程管理工具类代码； "
            , "包含了Camera1.0、Camera2.0使用的示例代码以及抽取的相关工具类方法代码； "};

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
        for (int i = 0; i < mItemNamesArray.length; i++) {
            mItemInfoMap = new HashMap<>();
            mItemInfoMap.put("title", mItemNamesArray[i]);
            mItemInfoMap.put("introduce", mItemIntroduceInfoArray[i]);
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
            case 0:
                intent = new Intent(MainActivity.this, LogToolActivity.class);
                startActivity(intent);
                break;
            case 1:
                Toast.makeText(this, "You Have Chose : Item" + (position + 1) , Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "You Have Chose : Item" + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "You Have Chose : Item" + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "You Have Chose : Item" + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this, "You Have Chose : Item" + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(this, "You Have Chose : Item" + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 9:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 10:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 11:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 12:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 13:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 14:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 15:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 16:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 17:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 18:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 19:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
                break;
            case 20:
                Toast.makeText(this, "You Have Chose : Item " + (position + 1), Toast.LENGTH_SHORT).show();
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
            return mItemNamesArray.length;
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
            holder.introduction.setText("内容介绍：\n        " + listItemNames.get(position).get("introduce").toString());
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

}
