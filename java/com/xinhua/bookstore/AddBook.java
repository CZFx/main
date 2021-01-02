package com.xinhua.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xinhua.bookstore.Table.Book;
import com.xinhua.bookstore.Table.Category;

import org.litepal.crud.DataSupport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddBook extends AppCompatActivity {

    private List<Category> categoryList = new ArrayList<>();
    RecyclerView recyclerView;

    public void init() {
        categoryList = DataSupport.findAll(Category.class);
        recyclerView = findViewById(R.id.add_book_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AddBookAdapter(categoryList));
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
            EditText dateEditText = findViewById(R.id.add_book_date);
            EditText priceEditText = findViewById(R.id.add_book_price);
            EditText imageIdEditText = findViewById(R.id.add_book_imageId);

            String name = nameEditText.getText().toString();
            String author = authorEditText.getText().toString();
            String press = pressEditText.getText().toString();
            double price = Double.parseDouble(priceEditText.getText().toString());
            int imageId = Integer.parseInt(imageIdEditText.getText().toString());
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = fmt.parse(dateEditText.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            new Book(imageId, name, author, press, date, price).save();
            Toast.makeText(this, "add succeed", Toast.LENGTH_SHORT).show();
        });

    }
}