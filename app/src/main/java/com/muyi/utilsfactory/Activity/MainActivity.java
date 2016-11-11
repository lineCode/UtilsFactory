package com.muyi.utilsfactory.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.muyi.utilsfactory.LogUtils.LogCatchUtils;
import com.muyi.utilsfactory.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Author:  Miuky
 * Time:    2016.11.11
 * Title:   MainActivity
 * Desc:    App's Entrance Class, the first page when user
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogCatchUtils logCatchUtils  = new LogCatchUtils(this,null);
        logCatchUtils.startSaveLog();

        Log.e("Miuky","测试日志抓取并写入本地文件");
        ((TextView)findViewById(R.id.tv_show)).setText("文件目录：Android/data/com.muyi.utilsfactory/日期.log");
        Toast.makeText(this,"文件目录：Android/data/com.muyi.utilsfactory/日期.log",Toast.LENGTH_LONG).show();

    }
}
