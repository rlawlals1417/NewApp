package com.example.lg.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        container = (FrameLayout) findViewById(R.id.container);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            LayoutInflater inflater = (LayoutInflater) getSystemService(getBaseContext().LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.sub1, container, true);
            }


        });



    }
    public void onClick2(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
    public void onClick3(View v){
        Intent intent = new Intent(this, MyIntent.class);
        startActivity(intent);
    }
    public void onClick4(View v){
        Intent intent = new Intent(this, MyParcelable.class);
        startActivity(intent);
    }

}
