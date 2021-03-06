package com.example.zhoushx.activitytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by zhoushx on 2015/12/10.
 */
public class SecondActivity extends BaseActivity {

    private String TAG;

    @Override
    protected void onCreate(Bundle saved) {
        TAG = "TAG_" + this.toString().substring(this.toString().lastIndexOf('.') + 1);

        super.onCreate(saved);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);

        Toast.makeText(SecondActivity.this, "onCreate 222222222 SecondActivity",
                Toast.LENGTH_SHORT).show();


        //按键
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(getPackageName() + "|" + getLocalClassName(), "button_2 onClick");

                dealIntent();
                finish();
            }
        });


        Log.d(TAG, "Task=" + getTaskId());
        //按键
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        dealIntent();
        finish();
    }

    //接收 intent, 同时设置 intent result
    private void dealIntent() {
        Intent intent = getIntent();
        String strData = intent.getStringExtra("extra_data");

        Toast.makeText(SecondActivity.this, "recv data=" + strData,
                Toast.LENGTH_SHORT).show();

        strData = strData + "|ackText from SecondActivity";
        intent.putExtra("extra_data", strData);

        setResult(RESULT_OK, intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

}
