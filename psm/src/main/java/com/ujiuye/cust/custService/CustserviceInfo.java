package com.ujiuye.cust.custService;

import com.ujiuye.cust.custBean.Customer;
import com.ujiuye.cust.custBean.CustomerExample;
import com.ujiuye.cust.custMapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class CustserviceInfo implements custservice {

    @Resource
    private CustomerMapper customerMapper;


    //查找客户列表
    public List<Customer> getCuscompanyList() {
        CustomerExample customerExample=new CustomerExample();
        return customerMapper.selectByExample(customerExample);
    }
    //删除客户
    public Boolean deleteCust(Integer[] ids) {
        CustomerExample customerExample=new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return customerMapper.deleteByExample(customerExample)>0;
    }
        //根据ID查询单条用户
    public Customer getCompanyperson(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }
    //修改客户信息
    public Boolean updateByid(Customer customer) {
        return customerMapper.updateById(customer)>0;
    }
            //添加客户信息
    public Boolean addCust(Customer customer) {
        return customerMapper.insertSelective(customer)>0;
    }




}
