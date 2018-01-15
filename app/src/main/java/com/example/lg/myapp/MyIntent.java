package com.example.lg.myapp;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyIntent extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, 101);
                //startActivity 와 다른점
                //어떤 화면에서 응답을 받았는지 응답 코드를 준다.

            }
        });

        editText = (EditText) findViewById(R.id.editText);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String receiver = editText.getText().toString();  //입력상자에서 텍스트 가져오기
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ receiver)); //전화걸기 앱 띄워주기
            startActivity(intent);

           Intent intent2 = new Intent();
           ComponentName name = new ComponentName("com.example.lg.myapp", "com.example.lg.myapp.MainActivity");

           intent2.setComponent(name);
            startActivity(intent2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), "응답 : "+name,Toast.LENGTH_LONG).show();

        }
    }
}
