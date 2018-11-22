package com.atguigu.javaweb.test;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class Customer implements HttpSessionBindingListener,
        HttpSessionActivationListener, Serializable {

    private String time;

    public void setTime(String time) {
        this.time = time;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("绑定到session...");

        Object value = event.getValue();
        System.out.println(value == this);
        System.out.println(event.getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("从session中解除绑定...");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("从内存中写到磁盘上...");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("从磁盘中读取出来...");
    }
}
