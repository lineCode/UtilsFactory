package com.muyi.utilsfactory;

import android.app.Application;
import android.content.Context;

/**
 * Created by yoyid on 2016/11/11.
 *
 */

public class UtilsFactoryApplication extends Application {

    public Context mContext;
    private static UtilsFactoryApplication utilsInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        utilsInstance = this;
    }

    public static UtilsFactoryApplication getInstance(){
        return utilsInstance ;
    }
}
