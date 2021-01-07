package com.xinhua.bookstore;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xinhua.bookstore.Table.BC;
import com.xinhua.bookstore.Table.Book;

import org.litepal.crud.DataSupport;

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
        holder.book_price.setText("￥" + book.getPrice());
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
            Intent intent = new Intent(v.getContext(), BookContent.class);
            intent.putExtra("book", book);
            v.getContext().startActivity(intent);
        });
        //长按可以进行编辑或者修改
        holder.bookView.setOnLongClickListener(v -> {
            int position=holder.getAdapterPosition();
            View view1 = View.inflate(v.getContext(), R.layout.book_long_click_dialog, null);
            Dialog dialog = new Dialog(v.getContext());
            dialog.setTitle("操作");
            dialog.setContentView(view1);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();

            Button bookDelete = view1.findViewById(R.id.book_delete);
            Button bookEdit = view1.findViewById(R.id.book_edit);

            bookDelete.setOnClickListener(v1 -> {
                AlertDialog.Builder deleteDialog = new AlertDialog.Builder(v.getContext());
                deleteDialog.setTitle("提示");
                deleteDialog.setMessage("确定要删除吗？");
                deleteDialog.setPositiveButton("确定", (dialog1, which) -> {
                    Book book = BookList.get(position);
                    DataSupport.deleteAll(Book.class, "id = ?", String.valueOf(book.getId()));
                    DataSupport.deleteAll(BC.class, "book_id = ?", String.valueOf(book.getId()));
                    v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));
                    Toast.makeText(v.getContext(), "删除成功", Toast.LENGTH_SHORT).show();
                });
                deleteDialog.setNegativeButton("取消", (dialog1, which) -> {
                });
                deleteDialog.show();
            });
            bookEdit.setOnClickListener(v1 -> {
                Book book = BookList.get(position);
                Intent intent = new Intent(v.getContext(), EditBook.class);
                intent.putExtra("book", book);
                v.getContext().startActivity(intent);
            });
            return true;
        });
        return holder;
    }
    public BookAdapter(List<Book> bookList) {
        BookList = bookList;
    }
}
