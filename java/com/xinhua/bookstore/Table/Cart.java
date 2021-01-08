package com.xinhua.bookstore.Table;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Cart extends DataSupport {
    private int id;//表中默认主键，没有实际意义
    private int user_id;//表中实际主键，与用户一对一关系
    private List<Book> bookList = new ArrayList<>();//用户购物车中的书

    public Cart() {
    }

    public Cart(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Book> getBookList() {
        bookList = DataSupport.where("cart_id = ?", String.valueOf(id)).find(Book.class);
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
