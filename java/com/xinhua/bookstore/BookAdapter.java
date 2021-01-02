package com.xinhua.bookstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xinhua.bookstore.Table.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> BookList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View bookView;
        TextView book_name;
        TextView book_author;
        TextView book_price;
        ImageView book_image;
        public ViewHolder(View view)
        {
            super(view);
            bookView = view;
            book_name = view.findViewById(R.id.book_name);
            book_author = view.findViewById(R.id.book_author);
            book_price = view.findViewById(R.id.book_price);
            book_image=view.findViewById(R.id.book_image);
        }

    }
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book=BookList.get(position);
        holder.book_price.setText(String.valueOf(book.getPrice()));
        holder.book_name.setText(book.getName());
        holder.book_author.setText(book.getAuthor());
        holder.book_image.setImageResource(book.getImageId());
    }
    public int getItemCount() {
        return BookList.size();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        final  ViewHolder holder=new ViewHolder(view);
        holder.bookView.setOnClickListener(v -> {
            int position=holder.getAdapterPosition();
            Book book=BookList.get(position);
            Toast.makeText(v.getContext(),"you click view"+book.getName(),
                    Toast.LENGTH_SHORT).show();
        });

            return  holder;
    }
    public BookAdapter(List<Book> bookList) {
        BookList = bookList;
    }
}
