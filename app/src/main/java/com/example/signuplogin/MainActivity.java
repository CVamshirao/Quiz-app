package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.txt_view);
        button1=findViewById(R.id.btn_play);
        button2=findViewById(R.id.btn_setting);
        button3=findViewById(R.id.btn_exit);
        Toast.makeText(MainActivity.this,"Developed By VAMSHI",Toast.LENGTH_LONG).show();

        //applying events

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,playActivity.class);
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(MainActivity.this,playActivity.class);
                //startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

    }


}