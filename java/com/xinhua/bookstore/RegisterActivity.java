package com.xinhua.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xinhua.bookstore.Table.User;

import org.litepal.crud.DataSupport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button registerEditText = findViewById(R.id.register);
        EditText usernameEditText = findViewById(R.id.reg_username);
        usernameEditText.setText(getIntent().getStringExtra("username"));

        String sex = null;
        RadioGroup radioGroup = findViewById(R.id.sex_radio_group);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = findViewById(checkedId);
            //sex = radioButton.getText().toString();
        });

        registerEditText.setOnClickListener(v -> {
            EditText passwordEditText = findViewById(R.id.reg_password);
            EditText birthEditText = findViewById(R.id.reg_birth);
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            boolean flag = true;
            flag = (flag && username.matches("^[^0-9][\\w_]{5,9}$"));
            flag = (flag && password.matches("^[\\w_]{6,20}$"));
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            Date birth = null;
            try {
                birth = fmt.parse(birthEditText.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (flag && birth != null && sex != null){
                new User(username, password, birth, sex).save();
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "请完善信息", Toast.LENGTH_SHORT).show();
            }
        });
    }
}