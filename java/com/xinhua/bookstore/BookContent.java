package com.xinhua.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinhua.bookstore.Table.Book;

public class BookContent extends Activity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_content);
        Book book = (Book) getIntent().getSerializableExtra("book");
        ImageView imageId = findViewById(R.id.content_imageid);
        TextView price = findViewById(R.id.content_price);
        TextView name = findViewById(R.id.content_book_name);
        TextView author = findViewById(R.id.content_author);
        TextView press = findViewById(R.id.content_press);
        Button cart = findViewById(R.id.content_chart);
        Button addToCart = findViewById(R.id.content_add_chart);

        imageId.setImageResource(book.getImageId());
        price.setText("￥" + book.getPrice());
        name.setText(book.getName());
        author.setText("作者：" + book.getAuthor());
        press.setText("出版社：" + book.getPress());

        cart.setOnClickListener(v -> {
            startActivity(new Intent(this, ShoppingCart.class));
        });
        addToCart.setOnClickListener(v -> {
            //startActivity(new Intent(this, AddShoppingCart.class));
            //透明底部弹窗
            Dialog dialog = new Dialog(this, R.style.DialogBottom);
            dialog.getWindow().setGravity(Gravity.BOTTOM);
            dialog.setContentView(R.layout.activity_add_shopping_cart);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
        });
    }
}
