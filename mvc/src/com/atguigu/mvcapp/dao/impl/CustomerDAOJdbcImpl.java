package com.atguigu.mvcapp.dao.impl;

import java.util.List;

import com.atguigu.mvcapp.dao.CriteriaCustomer;
import com.atguigu.mvcapp.dao.CustomerDAO;
import com.atguigu.mvcapp.dao.DAO;
import com.atguigu.mvcapp.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO {

    // 查询所有的customer
    @Override
    public List<Customer> getAll() {
        String sql = "select id,name,address,phone from customers1";
        return getForList(sql);
    }

    // 保存一个customer
    @Override
    public void sava(Customer customer) {
        String sql = "insert into customers1(name,address,phone)values(?,?,?)";
        update(sql, customer.getName(), customer.getAddress(), customer.getPhone());
    }

    // 更新时根据id查询到要更新的customer
    @Override
    public Customer get(Integer id) {
        String sql = "select id,name,address,phone from customers1 where id=?";
        return get(sql, id);
    }

    // 根据id删除一个customer
    @Override
    public void delete(Integer id) {
        String sql = "delete from customers1 where id=?";
        update(sql, id);

    }

    /**
     * 返回和 name 相等的记录数.
     *
     * @param name
     * @return
     */
    @Override
    public long getCountWithName(String name) {
        String sql = "select count(id) from customers1 where name=?";
        return getForValue(sql, name);
    }


    //查询全部customers和模糊查询功能
    @Override
    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
        String sql = "select id,name,address,phone from customers1 where name like ? and address like ? and phone like ?";
        // 修改了 CriteriaCustomer 的 getter 方法: 使其返回的字符串中有 "%%".
        // 若返回值为 null 则返回 "%%", 若不为 null, 则返回 "%" + 字段本身的值 + "%"
        return getForList(sql, cc.getName(), cc.getAddress(), cc.getPhone());
    }

    //修改
    @Override
    public void update(Customer customer) {
        String sql = "update customers1 set name=?,address=?,phone=? where id=?";
        update(sql, customer.getName(), customer.getAddress(), customer.getPhone(), customer.getId());

    }

}
