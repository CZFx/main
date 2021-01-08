package com.xinhua.bookstore.Table;

import org.litepal.crud.DataSupport;

import java.util.Date;

public class User extends DataSupport {
    private int id;//表中主键，用户身份的唯一标识
    private String username;//用户名
    private String password;//密码
    private Date birth;//用户生日
    private String sex;//用户性别
    private boolean root;//是否为管理员
    private int cart_id;//用户所对应的购物车

    public User(String username, String password, Date birth, String sex) {
        this.username = username;
        this.password = password;
        this.birth = birth;
        this.sex = sex;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }
}
