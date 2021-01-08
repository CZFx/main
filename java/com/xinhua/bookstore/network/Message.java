package com.xinhua.bookstore.network;

import java.io.Serializable;

public class Message implements Serializable {
    public String s;
    private static final long serialVersionUID = 1L;
    public Message() {
        ;
    }
    public Message(String s) {
        this.s = s;
    }
}
