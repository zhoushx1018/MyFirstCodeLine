package com.example.zhoushx.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by zhoushx on 2015/12/10.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle saved) {
        super.onCreate(saved);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);

        Toast.makeText(SecondActivity.this, "onCreate 222222222 SecondActivity",
                Toast.LENGTH_LONG).show();
    }
}