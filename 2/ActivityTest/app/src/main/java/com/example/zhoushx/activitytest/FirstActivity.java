package com.example.zhoushx.activitytest;

/**
 * Created by zhoushx on 2015/12/9.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TAG = "TAG_" + this.toString().substring(this.toString().lastIndexOf('.') + 1);

        super.onCreate(savedInstanceState);

        Toast.makeText(FirstActivity.this, "onCreate 1111111111",
                Toast.LENGTH_LONG).show();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this, "You clicked Button 1",
//                        Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                Intent intent = new Intent("com.example.zhoushx.activitytest.ACTION_START");
//                Intent intent = new Intent("com.example.zhoushx.activitytest.ACTION_START");
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
//
//                try {
//                    startActivity(intent);
//                } catch (Exception e) {
//                    Toast.makeText(FirstActivity.this, "catch error"+ e.toString(),
//                            Toast.LENGTH_LONG).show();
//
//                } finally {
//                    Toast.makeText(FirstActivity.this, "finally error",
//                            Toast.LENGTH_LONG).show();
//                }

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);

                Log.d(TAG, "button_1 onClick");

            }
        });

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button button3 = (Button) findViewById(R.id.button_dial);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        Log.d(TAG, "Task=" + getTaskId());
        Button button4 = (Button) findViewById(R.id.button_sendToSccondActivity);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello SecondActivity111111111";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });

        Button button5 = (Button) findViewById(R.id.button_sendToSccondActivity_forResult);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello SecondActivity222222222";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivityForResult(intent, 1);
            }
        });

        Log.d(TAG, "启动活动，intent 指向自己， 创建按键 事件");
        Button button6 = (Button) findViewById(R.id.button_startActivity_intentToSelf);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        Toast.makeText(FirstActivity.this, "onCreateOptionsMenu 22222222222222",
                Toast.LENGTH_LONG).show();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Toast.makeText(FirstActivity.this, "onActivityResult",
                Toast.LENGTH_SHORT).show();

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("extra_data");
                    Toast.makeText(FirstActivity.this, "ack text=" + returnedData,
                            Toast.LENGTH_SHORT).show();
                }

                break;
            default:
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key", tempData);

        Log.d(TAG, "SavedData before OnStop activity|data_key=" + tempData);
    }

}
