package com.atguigu.mvcapp.dao;

import com.atguigu.mvcapp.domain.Customer;

import java.util.List;

public interface CustomerDAO {

    //查询所有的customer
    public List<Customer> getAll();

    //保存一个customer
    public void sava(Customer customer);

    //更新时根据id查询到要更新的customer
    public Customer get(Integer id);

    //根据id删除一个customer
    public void delete(Integer id);

    //修改
    public void update(Customer customer);

    /**
     * 返回和 name 相等的记录数.
     *
     * @param name
     * @return
     */
    public long getCountWithName(String name);

    //
    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);

}
