package com.muyi.utilsfactory.LogUtils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;


/**
 * Author:  Miuky
 * Time:    2016.11.11
 * Desc:    All Log Catch and Save To local Storage
 */
public class LogCatchUtils {

    private static LogCatchUtils instance = null;
    private String dirPath;
    private int appid;
    private Thread logThread;

    /**
     * 获取日志抓取实体对象
     *
     * @param context
     * @param path    log日志保存路径
     * @return
     */
    public LogCatchUtils getInstance(Context context, String path) {
        if (instance == null) {
            instance = new LogCatchUtils(context, path);
        }
        return instance;
    }

    /**
     * 该类的构造方法
     * 判断文件保存的路径是否存在的逻辑处理
     *
     * @param context
     * @param path    log日志文件保存路径
     */
    public LogCatchUtils(Context context, String path) {
        appid = android.os.Process.myPid();
        if (TextUtils.isEmpty(path)) {
            dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + context.getPackageName();
        } else {
            dirPath = path;
        }
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * 启动保存日志的线程
     */
    public void startSaveLog() {
        if (logThread == null) {
            logThread = new Thread(new LogRunnable(appid, dirPath));
        }
        logThread.start();
    }

    /**
     *  线程运行
     *  01 判断目录结构是否存在；
     *  02 存在则创建文件并写入日志内容；
     *  03 不存在则创建目录和文件并写入日志内容；
     */
    private class LogRunnable implements Runnable {

        private Process mProcess;
        private FileOutputStream fos;
        private BufferedReader mReader;
        private String cmds, mPid;

        public LogRunnable(int pid, String dirPath) {
            this.mPid = "" + pid;
            try {
                File file = new File(dirPath, FormatDate.getFormatDate() + ".log");
                if (!file.exists()) {
                    file.createNewFile();
                }
                fos = new FileOutputStream(file, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cmds = "logcat *:v | grep \"(" + mPid + ")\"";
        }

        /**
         * 写入日志内容
         */
        @Override
        public void run() {
            try {
                mProcess = Runtime.getRuntime().exec(cmds);
                mReader = new BufferedReader(new InputStreamReader(mProcess.getInputStream()), 1024);
                String line;
                while ((line = mReader.readLine()) != null) {
                    if (line.length() == 0) {
                        continue;
                    }
                    if (fos != null && line.contains(mPid)) {
                        fos.write((FormatDate.getFormatTime() + " " + line + "\r\n").getBytes());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (mProcess != null) {
                    mProcess.destroy();
                    mProcess = null;
                }
                try {
                    if (mReader != null) {
                        mReader.close();
                        mReader = null;
                    }
                    if (fos != null) {
                        fos.close();
                        fos = null;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }


    /**
     * 日期格式化工具方法
     */
    @SuppressLint("SimpleDateFormat")
    private static class FormatDate {

        public static String getFormatDate() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
            return sdf.format(System.currentTimeMillis());
        }

        public static String getFormatTime() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
            return sdf.format(System.currentTimeMillis());
        }
    }
}
