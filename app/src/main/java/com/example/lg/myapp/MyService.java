package com.example.lg.myapp;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {
    private static final String TAG = "MyService";
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate() 호출됨.");
    }

    @Override       //intent 객체는 onStartCommand 에서 명령어를 처리 해 주세요
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() 호출됨.");
        if (intent== null){
            return Service.START_STICKY; //서비스 종료되었을때도 다시 자동으로 실행해 달라
        }else{
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);

    }
    private void processCommand(Intent intent){
        String command = intent.getStringExtra("command");
        String name =intent.getStringExtra("name");
        Log.d(TAG, "전달받은 데이터 : "+command + ", "+name);

        try {               //5초동안 쉰다.
            Thread.sleep(5000);
        }catch(Exception e){};
        Intent showIntent = new Intent(getApplicationContext(), MenuActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                            Intent.FLAG_ACTIVITY_SINGLE_TOP|
                            Intent.FLAG_ACTIVITY_CLEAR_TOP);
        showIntent.putExtra("command","show");
        showIntent.putExtra("name", name + "from service.");
        startActivity(showIntent);      //여기까지 하면 문제 생김 서비스 화면 x 화면쪽에서 화면을 띄워달라? 문제 ㅇㅇ 화면은 task
                                        //화면이 없는데 화면을 띄우면 task 가 없어서 못띄움 --> 옵션을 줘야됨 flag 를통해

    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() 호출됨.");
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }



}
