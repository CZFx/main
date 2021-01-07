package com.xinhua.bookstore.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xinhua.bookstore.MainActivity;
import com.xinhua.bookstore.R;
import com.xinhua.bookstore.RegisterActivity;
import com.xinhua.bookstore.Table.User;

import org.litepal.crud.DataSupport;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        System.out.println(R.drawable.bookphoto2);
        Button blogin, bregister;
        blogin = findViewById(R.id.login_login);
        bregister = findViewById(R.id.login_register);
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username, password;
                username = findViewById(R.id.login_username);
                password = findViewById(R.id.login_password);

                List<User> userList = DataSupport.where("username = ?", username.getText().toString()).find(User.class);
                if(userList.size() != 0 && userList.get(0).getPassword().equals(password.getText().toString())) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
