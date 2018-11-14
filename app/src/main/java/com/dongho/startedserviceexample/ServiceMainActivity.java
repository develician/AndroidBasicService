package com.dongho.startedserviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ServiceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
    }

    public void mOnClick(View v) {
        Intent intent = new Intent(ServiceMainActivity.this, MyService.class);
        switch (v.getId()) {
            case R.id.btnPlayMusic:
                intent.setAction("test.example.PLAYMUSIC");
                startService(intent);
                break;
            case R.id.btnDownload:
                intent.setAction("test.example.DOWNLOAD");
                startService(intent);
                break;
            case R.id.btnStopService:
                stopService(intent);
                break;
        }
    }
}
