package com.ujiuye.emp.empController;

import com.ujiuye.emp.empBean.Employee;
import com.ujiuye.system.sysBean.Sources;
import com.ujiuye.utils.ImageVerificationCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ujiuye.emp.empService.EmpService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ujiuye.system.sysService.SourceService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class empcontroller {
    @Resource
    private EmpService empService;
   @Resource
    private SourceService sourceService;
    //获取经理列表
    @RequestMapping(value = "/getManagerList",method = RequestMethod.GET)
    @ResponseBody
  public List<Employee> getManagerList(){
     return empService.getManagerList();
  }
    @RequestMapping(value = "/getManagerByid",method = RequestMethod.GET)
    @ResponseBody
    public Employee getManagerByid(Integer empFk){
        return empService.getManagerByid(empFk);
    }
    @RequestMapping(value = "/getEmps",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmps(){
        return empService.getEmps();
    }
    //登录验证码
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response){
        try{
            ImageVerificationCode ivc = new ImageVerificationCode();     //用我们的验证码类，生成验证码类对象
            BufferedImage image = ivc.getImage();  //获取验证码
            request.getSession().setAttribute("text", ivc.getText()); //将验证码的文本存在session中
            ivc.output(image, response.getOutputStream());

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //登录
    @RequestMapping(value = "/loginValidate",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> loginValidate(Employee employee, String code,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        HttpSession session = request.getSession();
        String codes = (String) session.getAttribute("text");
        session.removeAttribute("text");
        if(code.equalsIgnoreCase(codes)){
            boolean flag=empService.loginValidate(employee,session);
            if(flag){
                List<Employee> loginUser =  (List<Employee>)session.getAttribute("loginUser");
                Employee emp = loginUser.get(0);
                List<Sources> secondSources=sourceService.getSecondSourcesListByEid(emp.getEid());
                session.setAttribute("secondSources",secondSources);
                map.put("statusCode",200);
            }else {
                map.put("statusCode",500);
            }
        }else {
            map.put("statusCode",499);
        }
        return map;
    }

}
