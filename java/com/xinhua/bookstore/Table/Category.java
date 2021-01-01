package com.xinhua.bookstore.Table;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Category extends DataSupport {
    private int id;//表中主键,每种种类对应的编号
    private String category;//书的种类
    private List<BC> bookList = new ArrayList<>();//这种类型的书

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public List<BC> getBookList() {
        bookList = DataSupport.where("category_id = ?", String.valueOf(id)).find(BC.class);
        return bookList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
