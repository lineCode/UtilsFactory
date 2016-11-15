package com.muyi.utilsfactory.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.muyi.utilsfactory.LogUtils.LogCatchUtils;
import com.muyi.utilsfactory.R;

/**
 * Created by yoyid on 2016/11/15.
 */

public class LogToolActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvTextDisplay;
    private Button mBtnGenerateLogFile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_tool);

        initView();
        initData();
    }

    private void initView() {
        mTvTextDisplay = ((TextView) findViewById(R.id.tv_textDisplay));
        mBtnGenerateLogFile = (Button) findViewById(R.id.btn_generateLogFile);
    }

    private void initData() {
        mBtnGenerateLogFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_generateLogFile:
                if (mTvTextDisplay.getText().equals("文本展示")) {
                    LogCatchUtils logCatchUtils = new LogCatchUtils(this, null);
                    logCatchUtils.startSaveLog();
                    Log.e("Miuky", "测试日志抓取并写入本地文件");
                    mTvTextDisplay.setText("Gen file local path：\nAndroid/data/com.muyi.utilsfactory/log/DATE.log");
                } else {
                    mTvTextDisplay.setText("You have generated local log file!");
                }
                break;
        }
    }
}
