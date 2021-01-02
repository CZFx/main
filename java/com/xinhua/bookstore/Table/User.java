package com.xinhua.bookstore.Table;

import org.litepal.crud.DataSupport;

import java.util.Date;

public class User extends DataSupport {
    private int id;
    private String username;
    private String password;
    private Date birth;
    private String sex;
    private boolean root;

    public User(String username, String password, Date birth, String sex) {
        this.username = username;
        this.password = password;
        this.birth = birth;
        this.sex = sex;
    }

    public User() {
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
