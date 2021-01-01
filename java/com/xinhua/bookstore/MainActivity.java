package com.xinhua.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.xinhua.bookstore.Table.BC;
import com.xinhua.bookstore.Table.Book;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList;
    private RecyclerView recyclerView;

    public void init() {


        Connector.getDatabase();
        bookList = DataSupport.findAll(Book.class);
        //创建布局管理，加载RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bookList = DataSupport.findAll(Book.class);
        recyclerView.setAdapter(new StuAdapter(studentList));
        /*//新增按钮监听器
        Button addStudent = findViewById(R.id.add_stu);
        addStudent.setOnClickListener(v -> {
            startActivity(new Intent(this, AddStudent.class));
        });*/
    }
}