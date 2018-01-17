package com.example.lg.myapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_life_cycle);

        Toast.makeText(this, "onCreate() 호출됨",Toast.LENGTH_LONG).show();

        Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }

    //수명주기 메서드
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart() 호출됨",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop() 호출됨",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy 호출됨",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {  //보통 이때 중요한 정보들을 저장
        super.onPause();
        Toast.makeText(this,"onPause 호출됨",Toast.LENGTH_LONG).show();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE); //정보를 쉽게 저장 ->간단한 설정정보 등
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name","모모랜드");
        editor.commit();

    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume 호출됨",Toast.LENGTH_LONG).show();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if(pref != null){
            String name = pref.getString("name","");
            Toast.makeText(this, "복구된 이름" + name, Toast.LENGTH_LONG).show();
        }

    }
}
