package com.example.zhoushx.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by acer on 2015/12/12.
 */
public class BaseActivity extends Activity {
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TAG = "TAG_" + this.toString().substring(this.toString().lastIndexOf('.') + 1)
                + "|BaseActivity";

        super.onCreate(savedInstanceState);
        Log.d(TAG,  getClass().getSimpleName());

        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
