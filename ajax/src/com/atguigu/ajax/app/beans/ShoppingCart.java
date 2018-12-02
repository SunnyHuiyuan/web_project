package com.atguigu.ajax.app.beans;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private String bookName;
    //存放ShoppingCartItem的Map:  键：书名，值：ShoppingCartItem对象
    private Map<String, ShoppingCartItem> items = new HashMap<>();

    /**
     * 将书本加入的方法
     *
     * @param bookname
     * @param price
     */
    public void addToCart(String bookname, int price) {

        this.bookName = bookname;

        if (items.containsKey(bookname)) {
            ShoppingCartItem item = items.get(bookname);
            item.setNumber(item.getNumber() + 1);
        } else {
            ShoppingCartItem item = new ShoppingCartItem();
            item.setBookname(bookname);
            item.setPrice(price);
            item.setNumber(1);

            items.put(bookname, item);
        }
    }

    /**
     * 书本的总数
     *
     * @return
     */
    public int getTotleBookNumber() {
        int totle = 0;
        for (ShoppingCartItem item : items.values()) {
            totle += item.getNumber();
        }
        return totle;
    }

    /**
     * 书本的总价钱
     *
     * @return
     */
    public int getTotleMoney() {
        int money = 0;
        for (ShoppingCartItem item : items.values()) {
            money += item.getNumber() * item.getPrice();
        }
        return money;
    }

    public String getBookName() {
        return bookName;
    }
}
