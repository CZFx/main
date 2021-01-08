package com.xinhua.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xinhua.bookstore.Table.BC;
import com.xinhua.bookstore.Table.Book;
import com.xinhua.bookstore.Table.Category;

import org.litepal.crud.DataSupport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddBook extends Activity {

    private List<Category> categoryList = new ArrayList<>();
    private RecyclerView recyclerView;
    AddBookAdapter adapter;

    public void init() {
        categoryList = DataSupport.findAll(Category.class);
        recyclerView = findViewById(R.id.add_book_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AddBookAdapter(categoryList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        init();

        Button addBook = findViewById(R.id.add_book);
        addBook.setOnClickListener(v -> {
            EditText nameEditText = findViewById(R.id.add_book_name);
            EditText authorEditText = findViewById(R.id.add_book_author);
            EditText pressEditText = findViewById(R.id.add_book_press);
            EditText priceEditText = findViewById(R.id.add_book_price);
            EditText imageIdEditText = findViewById(R.id.add_book_imageId);
            EditText numEditText = findViewById(R.id.add_book_num);

            String name = nameEditText.getText().toString();
            String author = authorEditText.getText().toString();
            String press = pressEditText.getText().toString();
            double price = Double.parseDouble(priceEditText.getText().toString());
            int imageId = Integer.parseInt(imageIdEditText.getText().toString());
            int num = Integer.parseInt(numEditText.getText().toString());

            Book book = new Book(imageId, name, author, press, num, price);
            book.save();
            book = DataSupport.findLast(Book.class);
            Map<String, Boolean> checkStatus = adapter.getCheckStatus();
            List<Category> checkedCategoryList = new ArrayList<>();
            for (String key : checkStatus.keySet()) {
                checkedCategoryList = DataSupport.where("category = ?", key).find(Category.class);
                new BC(book.getId(), checkedCategoryList.get(0).getId()).save();
                Log.d("AddBook", String.valueOf(book.getId()));
                Log.d("AddBook", String.valueOf(checkedCategoryList.get(0).getId()));
            }

            Toast.makeText(this, "add succeed", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}