package com.xinhua.bookstore.Table;

import org.litepal.crud.DataSupport;

public class BC extends DataSupport {
    private int id;//主键，没有实际意义
    private int book_id;//外键，被参考表为Book
    private int category_id;//外键，被参考表为Category

    public BC() {
    }

    public BC(int book_id, int category_id) {
        this.book_id = book_id;
        this.category_id = category_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
