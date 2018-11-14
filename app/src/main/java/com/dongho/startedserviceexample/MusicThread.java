package com.dongho.startedserviceexample;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;




public class MusicThread extends Thread {
    private Context context;
    private static final String MSG_KEY = "1";

    public MusicThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        super.run();

        Message msg = handler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putString(MSG_KEY, "음악 재생 시작");
        msg.setData(bundle);
        handler.sendMessage(msg);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        msg = handler.obtainMessage();
        bundle = new Bundle();
        bundle.putString(MSG_KEY, "음악 재생 종료");
        msg.setData(bundle);
        handler.sendMessage(msg);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(context,  msg.getData().getString(MSG_KEY), Toast.LENGTH_SHORT).show();

        }
    };
}
