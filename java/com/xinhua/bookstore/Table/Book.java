package com.xinhua.bookstore.Table;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book extends DataSupport implements Serializable {
    private int id;//表中主键，也是书的唯一标识
    private int imageId;//图片资源ID
    private String name;//书名
    private String author;//作者
    private String press;//出版社
    private double price;//书的价格
    private int cart_id;//此字段只在书被加入购物车后才有实际意义
    private int num;//这是一个两用的变量，可以表示书的库存量（在图书列表界面）或者是书的数量（在购物车界面）
    private List<BC> categoryList = new ArrayList<>();//书的种类

    public Book() {
    }

    public Book(int imageId, String name, String author, String press, int num, double price) {
        this.imageId = imageId;
        this.name = name;
        this.author = author;
        this.press = press;
        this.price = price;
        this.num = num;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<BC> getCategoryList() {
        categoryList = DataSupport.where("book_id = ?", String.valueOf(id)).find(BC.class);
        return categoryList;
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
