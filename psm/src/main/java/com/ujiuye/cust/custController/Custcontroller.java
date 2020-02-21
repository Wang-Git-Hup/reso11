package com.ujiuye.cust.custController;

import com.ujiuye.cust.custBean.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ujiuye.cust.custService.custservice;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cust")
public class Custcontroller {
    @Resource
    private custservice service;
    //查找客户列表
    @RequestMapping(value = "getCuscompanyList",method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCuscompanyList(){
        return  service.getCuscompanyList();
    }
    //根据id获取单个客户
    @RequestMapping(value = "getCompanyperson",method = RequestMethod.GET)
    @ResponseBody
    public Customer getCompanyperson(Integer id){
        return  service.getCompanyperson(id);
    }
    //删除客户
    @RequestMapping(value = "deleteCust",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deleteCust(@RequestParam("ids[]") Integer  [] ids){
      Map<String,Object> map=new HashMap<String, Object>();
       Boolean flag= service.deleteCust(ids);
       if (flag){
           map.put("statuCode",200);
       }else
       {
           map.put("statuCode",500);
       }
       return  map;
    }
    //修改客户信息
    @RequestMapping(value = "updateByid",method = RequestMethod.PUT)
    @ResponseBody
    public Boolean updateByid(Customer customer){
      return   service.updateByid(customer);
    }

    //添加客户信息
    @RequestMapping(value = "addCust",method = RequestMethod.POST)
    @ResponseBody
    public Boolean addCust(Customer customer){
        customer.setAddtime(new Date());
        return   service.addCust(customer);
    }


}
