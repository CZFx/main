package com.xinhua.bookstore.network;

import android.content.Context;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

public class Mytoast extends Thread{
    String s;
    Context context;
    @Override
    public void run() {
        super.run();
        Looper.prepare();
        Toast toast = Toast.makeText(context, s, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
        Looper.loop();
    }

    public Mytoast(String s, Context context) {
        this.s = s;
        this.context = context;
    }
}
