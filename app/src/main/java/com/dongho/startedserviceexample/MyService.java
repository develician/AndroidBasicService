package com.dongho.startedserviceexample;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        // MusicThread thread = new MusicThread(this);
        switch (action) {
            case "test.example.PLAYMUSIC":
                new MusicThread(this).start();
                break;
            case "test.example.DOWNLOAD":
                Toast.makeText(this, "파일 다운로드 시작", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate() 호출!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy() 호출!", Toast.LENGTH_SHORT).show();
    }
}
