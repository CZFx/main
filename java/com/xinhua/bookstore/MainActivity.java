package com.xinhua.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xinhua.bookstore.Table.BC;
import com.xinhua.bookstore.Table.Book;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

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

    //增加数据库数据，进行一次测试
    public void test() {
        new Book(R.drawable.bookphoto2, "食品安全危机信息在社交媒体中的传播研究", "韩太平" ,"中国社会科学出版社",
                null, 45.60).save();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test();
        init();
    }

    @Override
    protected void onResume () {
        super.onResume();
        bookList = DataSupport.findAll(Book.class);
        recyclerView.setAdapter(new BookAdapter(bookList));
        //新增按钮监听器
        Button addStudent = findViewById(R.id.add_book_button);
        addStudent.setOnClickListener(v -> {
            startActivity(new Intent(this, AddBook.class));
        });
    }

}