package com.xinhua.bookstore.network;

import android.content.Context;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import com.xinhua.bookstore.network.Message;
public class BackThread extends Thread {
    private Context context;
    @Override
    public void run() {
        super.run();
        new Mytoast("尝试连接服务器", context).start();
        try {
            doit();
        } catch (Exception e) {
            e.printStackTrace();
            new Mytoast("连接失败", context).start();
        }
    }
    public BackThread(Context context) {
        this.context = context;
    }
    void doit() throws Exception{
        Socket socket = new Socket("10.17.77.168", 12345);
        new Mytoast("连接成功", context).start();
        byte b[] = new byte[1000];
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message message = (Message)ois.readObject();
        String str = message.s;
        new Mytoast(str, context).start();
    }
}
