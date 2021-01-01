package com.xinhua.bookstore.Table;

import org.litepal.crud.DataSupport;

public class User extends DataSupport {
    private int id;
    private String userName;
    private String passWord;
    private boolean root;

    public User(String userName, String passWord, boolean root) {
        this.userName = userName;
        this.passWord = passWord;
        this.root = root;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }
}
