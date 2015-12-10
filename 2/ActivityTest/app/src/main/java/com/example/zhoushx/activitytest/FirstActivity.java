package com.example.zhoushx.activitytest;

/**
 * Created by zhoushx on 2015/12/9.
 */

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);


            }
        });

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
}
