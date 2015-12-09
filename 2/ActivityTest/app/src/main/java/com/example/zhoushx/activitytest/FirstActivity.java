package com.example.zhoushx.activitytest;

/**
 * Created by zhoushx on 2015/12/9.
 */

        import android.os.Bundle;
        import android.app.Activity;
        import android.view.View;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.Toast;

public class FirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "You clicked Button 1",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}