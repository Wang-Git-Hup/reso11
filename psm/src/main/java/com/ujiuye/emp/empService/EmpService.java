package com.ujiuye.emp.empService;

import com.ujiuye.emp.empBean.Employee;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface EmpService {
    List<Employee> getManagerList();

    Employee getManagerByid(Integer empFk);

    List<Employee> getEmps();

    boolean loginValidate(Employee employee ,HttpSession session);
}
