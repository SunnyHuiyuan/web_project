package com.atguigu.ajax.app.test;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class Customer {

    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return "beijing";
    }

    @JsonIgnore
    public String getBirth() {
        return "1990-10-13";
    }

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) throws JsonProcessingException {
        //1.导入jar
        //2.创建ObjectMappter对象
        ObjectMapper mapper = new ObjectMapper();

        //3.调用mapper的writeValueAsString()方法把一个对象转为json字符串
        Customer customer = new Customer("atguigu", "1001");
        String jsonStr = mapper.writeValueAsString(customer);
        System.out.println(jsonStr);

        //4.注意，json使用getter方法来定位json对象的属性
        //5.可以通过添加注解@JsonIgnore来忽略某一个getter定义的属性
        List<Customer> customers = Arrays.asList(customer, new Customer("BCD", "2002"));
        jsonStr = mapper.writeValueAsString(customers);
        System.out.println(jsonStr);
    }
}
