package com.example.zhoushx.activitytest;

import android.app.Activity;
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
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle saved) {
        super.onCreate(saved);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);

        Toast.makeText(SecondActivity.this, "onCreate 222222222 SecondActivity",
                Toast.LENGTH_SHORT).show();


        //按键
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(getPackageName() + "|" + getLocalClassName(), "button_2 onClick");

                dealIntent();
                finish();
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
}
