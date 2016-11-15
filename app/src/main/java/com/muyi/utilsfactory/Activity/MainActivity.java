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
    private String[] mItemNamesArray = {"日志工具", "测试名称02", "测试名称03", "测试名称04",
            "测试名称05", "测试名称06", "测试名称07", "测试名称08", "测试名称09", "测试名称10", "测试名称11",
            "测试名称12", "测试名称13", "测试名称14", "测试名称15", "测试名称16", "测试名称17", "测试名称18",
            "测试名称19", "测试名称20"};
    private String[] mItemIntroduceInfoArray = {"包含了日志生成、日志筛选、日志打印优化等工具类；","Test introduce text for this tool package； "
            ,"Test introduce text for this tool package； ","Test introduce text for this tool package； ","Test introduce text for this tool package； "
            ,"Test introduce text for this tool package； ","Test introduce text for this tool package； ","Test introduce text for this tool package； "
            ,"Test introduce text for this tool package； ","Test introduce text for this tool package； ","Test introduce text for this tool package； "
            ,"Test introduce text for this tool package； ","Test introduce text for this tool package； ","Test introduce text for this tool package； "
            ,"Test introduce text for this tool package； ","Test introduce text for this tool package； ","Test introduce text for this tool package； "
            ,"Test introduce text for this tool package； ","Test introduce text for this tool package； ","Test introduce text for this tool package； "
            ,"Test introduce text for this tool package； "};

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
            mItemInfoMap.put("introduce",mItemIntroduceInfoArray[i]);
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
                Toast.makeText(this, "You Have Chose : " + (position + 1) + " Item", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "You Have Chose : " + (position + 1) + " Item", Toast.LENGTH_SHORT).show();
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
            holder.introduction.setText("Introduction："+listItemNames.get(position).get("introduce").toString());
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
