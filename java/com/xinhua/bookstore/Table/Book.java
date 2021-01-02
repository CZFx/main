package com.xinhua.bookstore.Table;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends DataSupport {
    private int id;//表中主键，也是书的唯一标识
    private int imageId;//图片资源ID
    private String name;//书名
    private String author;//作者
    private String press;//出版社
    private Date date;//出版日期
    private double price;//书的价格
    private List<BC> categoryList = new ArrayList<>();//书的种类


    public Book() {
    }

    /**
     *
     * @param imageId 图片资源ID
     * @param name 书名
     * @param author 作者
     * @param press 出版社
     * @param date 出版日期
     * @param price 书的价格
     */
    public Book(int imageId, String name, String author, String press, Date date, double price) {
        this.imageId = imageId;
        this.name = name;
        this.author = author;
        this.press = press;
        this.date = date;
        this.price = price;
    }

    public List<BC> getCategoryList() {
        categoryList = DataSupport.where("book_id = ?", String.valueOf(id)).find(BC.class);
        return categoryList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
