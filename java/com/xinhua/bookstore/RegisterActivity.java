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
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button registerEditText = findViewById(R.id.register);
        EditText usernameEditText = findViewById(R.id.reg_username);
        usernameEditText.setText(getIntent().getStringExtra("username"));


        RadioGroup radioGroup = findViewById(R.id.sex_radio_group);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = findViewById(checkedId);
            //sex = radioButton.getText().toString();
        });

        registerEditText.setOnClickListener(v -> {
            String sex = null;
            EditText passwordEditText = findViewById(R.id.reg_password);
            EditText birthEditText = findViewById(R.id.reg_birth);
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            RadioButton r1, r2;
            r1 = findViewById(R.id.sex_male);
            r2 = findViewById(R.id.sex_female);
            if(r1.isChecked()) sex = "男";
            if(r2.isChecked()) sex = "女";
            boolean flag = true;
            flag = (flag && username.matches("^[a-zA-Z0-9_-]{4,16}$"));
            flag = (flag && password.matches("[0-9A-Za-z\\W]{6,18}$"));
            DateFormat fmt =new SimpleDateFormat("YYYY-MM-DD");
            Date birth = null;
            try {
                birth = fmt.parse(birthEditText.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(flag) {
                List<User> userList = DataSupport.where("username = ?", usernameEditText.getText().toString()).find(User.class);
                if(userList.size() != 0) {
                    Toast.makeText(this, "用户名已被注册", Toast.LENGTH_SHORT).show();
                    return ;
                }
            }
            if (flag && birth != null && sex != null){
                new User(username, password, birth, sex).save();
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "请完善信息", Toast.LENGTH_SHORT).show();
            }
        });
    }
}