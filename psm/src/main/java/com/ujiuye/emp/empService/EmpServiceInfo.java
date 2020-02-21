package com.ujiuye.emp.empService;

import com.ujiuye.emp.empBean.Employee;
import com.ujiuye.emp.empBean.EmployeeExample;
import com.ujiuye.emp.empMapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
@Service
public class EmpServiceInfo implements  EmpService {
    @Resource
    private EmployeeMapper employeeMapper;
    public List<Employee> getManagerList() {
        EmployeeExample employeeExample=new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andPFkEqualTo(4);
        return employeeMapper.selectByExample(employeeExample);
    }

    public Employee getManagerByid(Integer empFk) {
        return employeeMapper.selectByPrimaryKey(empFk);
    }
            //用户登录
    public boolean loginValidate(Employee employee, HttpSession session) {
        EmployeeExample employeeExample=new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andUsernameEqualTo(employee.getUsername()).andPasswordEqualTo(employee.getPassword());
        session.setAttribute("loginUser",employeeMapper.selectByExample(employeeExample));
        return  employeeMapper.selectByExample(employeeExample).size()>0;
    }

    public List<Employee> getEmps() {
        EmployeeExample employeeExample=new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        Integer [] arr={1,2,3};
        criteria.andLFkIn(Arrays.asList(arr));
        return employeeMapper.selectByExample(employeeExample);
    }
}
