package com.example.zhoushx.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by zhoushx on 2015/12/10.
 */
public class ThirdActivity extends BaseActivity {

    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TAG = "TAG_" + this.toString().substring(this.toString().lastIndexOf('.') + 1);

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_layout);

        Log.d(TAG, "Task=" + getTaskId());

        Button buttonQuit = (Button) findViewById(R.id.button_quit);
        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                ActivityCollector.finishAll();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
