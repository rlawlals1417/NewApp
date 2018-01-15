package com.example.lg.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MyParcelable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_parcelable);

        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                

            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                ArrayList<String> names = new ArrayList<String>();
                names.add("김지민1");
                names.add("김지민2");

                intent.putExtra("names", names);

                SimpleData data = new SimpleData(100, "Hello");
                intent.putExtra("data",data);




                startActivityForResult(intent, 102);
            }
        });

    }
}
