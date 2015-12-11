package com.example.acer.activitylifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TAG = this.toString();

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //只有是被内存回收的 activity ， savedInstanceState 才不为空
        //  1、内存被回收的操作
        //      手机上使用360清理大师、猎豹清理大师等等 ，做 "手机加速"、"清理内存"操作，其实就是 强制回收进程
        //      这种情况下，并没有 销毁活动(即没 执行 Activity::onDestroy）
        //  2、正常的销毁活动
        //      在手机上长按 home键，打开活动列表，把相关活动划掉，此时是正常的销户活动，会执行 Activity::onDestroy
        //  3、强制销毁活动(系统"强行停止")
        //      "已安装应用管理" 相关应用, 做"强行停止"，是强制性的活动销户， 连 Activity::onDestroy 都不执行
        //  以上 1 savedInstanceState不为 null， 2和3 savedInstanceState为 null
        if (savedInstanceState != null) {

            Log.d(TAG, "11111111111");

            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, "getSavedData from destroy activity|data_key=" + tempData);
        }

        Log.d(TAG, "onCreate");

        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);

        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        DialogActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
