package com.xinhua.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xinhua.bookstore.Table.BC;
import com.xinhua.bookstore.Table.Book;
import com.xinhua.bookstore.Table.Category;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EditBook extends Activity {

    private List<Category> categoryList = new ArrayList<>();
    private RecyclerView recyclerView;
    AddBookAdapter adapter;

    public void init() {
        categoryList = DataSupport.findAll(Category.class);
        recyclerView = findViewById(R.id.edit_book_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AddBookAdapter(categoryList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);
        init();
        EditText nameEditText = findViewById(R.id.edit_book_name);
        EditText authorEditText = findViewById(R.id.edit_book_author);
        EditText pressEditText = findViewById(R.id.edit_book_press);
        EditText priceEditText = findViewById(R.id.edit_book_price);
        EditText imageIdEditText = findViewById(R.id.edit_book_imageId);

        Book book = (Book) getIntent().getSerializableExtra("book");
        nameEditText.setText(book.getName());
        authorEditText.setText(book.getAuthor());
        pressEditText.setText(book.getPress());
        priceEditText.setText(String.valueOf(book.getPrice()));
        imageIdEditText.setText(String.valueOf(book.getImageId()));

        Button editBook = findViewById(R.id.edit_book);
        editBook.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String author = authorEditText.getText().toString();
            String press = pressEditText.getText().toString();
            double price = Double.parseDouble(priceEditText.getText().toString());
            int imageId = Integer.parseInt(imageIdEditText.getText().toString());

            Book book1 = new Book(imageId, name, author, press, price);
            book1.updateAll("id = ?", String.valueOf(book.getId()));
            book1 = DataSupport.find(Book.class, book.getId());
            DataSupport.deleteAll(BC.class, "book_id = ?", String.valueOf(book1.getId()));

            Map<String, Boolean> checkStatus = adapter.getCheckStatus();
            List<Category> checkedCategoryList = new ArrayList<>();
            for (String key : checkStatus.keySet()) {
                checkedCategoryList = DataSupport.where("category = ?", key).find(Category.class);
                new BC(book1.getId(), checkedCategoryList.get(0).getId()).save();
                Log.d("editBook", String.valueOf(book1.getId()));
                Log.d("editBook", String.valueOf(checkedCategoryList.get(0).getId()));
            }

            Toast.makeText(this, "edit succeed", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}