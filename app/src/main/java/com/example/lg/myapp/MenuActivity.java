package com.example.lg.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
 EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu); //다른 xml 이라 id 충돌 안함

        editText2 = (EditText) findViewById(R.id.editText2);

        Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText2.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("command", "show");
                intent.putExtra("name",name);
                startService(intent);
            }
        });


        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {



                //메뉴화면에서 메인으로 데이터 전달?
                Intent intent = new Intent();
                intent.putExtra("name", "Kim"); //조연과 같은 역할 = 해석 x => 다른 액티비티로 전달
                setResult(Activity.RESULT_OK,intent);


                finish();

            }
        });

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent passedIntent = getIntent();
        processIntent(passedIntent);


    }
    private void processIntent(Intent intent){
        if (intent != null){
            ArrayList<String> names = (ArrayList<String>)intent.getSerializableExtra("names"); //Serializable
            if(names !=null) {
                Toast.makeText(getApplicationContext(), "전달받은 이름 리스트 갯수 : " + names.size(), Toast.LENGTH_LONG).show();
            }
            SimpleData data = (SimpleData) intent.getParcelableExtra("data");
            Toast.makeText(getApplicationContext(), "전달받은 SimpleData : " + data.message, Toast.LENGTH_LONG).show();

        }

        Intent passedIntent = getIntent();
        processCommand(passedIntent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(intent);

        super.onNewIntent(intent);
    }
    private void processCommand(Intent intent){
        if (intent != null){
            String command =intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this, "서비스로부터 전달받은 데이터 : " +command +", "+name, Toast.LENGTH_LONG).show();
        }
    }
}
