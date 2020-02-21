package com.ujiuye.cust.custService;

import com.ujiuye.cust.custBean.Customer;

import java.util.List;

public interface custservice {
    List<Customer> getCuscompanyList();

    Customer getCompanyperson(Integer id);

    Boolean deleteCust(Integer[] ids);

    Boolean updateByid(Customer customer);

    Boolean addCust(Customer customer);
}
