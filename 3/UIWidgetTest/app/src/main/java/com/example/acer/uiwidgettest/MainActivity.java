package com.example.acer.uiwidgettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TAG = "TAG_" + this.toString().substring(this.toString().lastIndexOf('.') + 1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.edit_text);
                String inputText = editText.getText().toString();
                Log.d(TAG, "editString=" + inputText);
            }
        });
    }
}
