package com.ujiuye.usual.usualController;

import com.ujiuye.emp.empBean.Employee;
import com.ujiuye.usual.usualBean.BaoXiao;
import com.ujiuye.utils.MarkInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ujiuye.usual.usualService.BaoXiaoService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/bao")
public class BaoXiaoController {
    @Resource
private BaoXiaoService baoXiaoService;
//获取报销单数据
    @RequestMapping(value = "getBao",method = RequestMethod.GET)
    @ResponseBody
public List<BaoXiao>  getBao(MarkInfo markInfo){
    return baoXiaoService.getBao(markInfo);
}
                //根据id获取报销数据
    @RequestMapping(value = "getOneBaoxiaoInfo",method = RequestMethod.GET)
    @ResponseBody
    public BaoXiao  getOneBaoxiaoInfo(BaoXiao baoXiao){
        return baoXiaoService.getOneBaoxiaoInfo(baoXiao);
    }
    //修改保险单信息
    @RequestMapping(value = "updateBxStatus",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateBxStatus(BaoXiao baoXiao){
        Map<String,Object> map=new HashMap<String, Object>();
       Boolean flag= baoXiaoService.updateBxStatus(baoXiao);
       if(flag){
           map.put("st",200);
       }else{
           map.put("st",500);
       }
        return map;
    }

    @RequestMapping(value = "saveInfo",method = RequestMethod.POST)
    public String saveInfo(BaoXiao baoXiao, HttpSession session){
        baoXiao.setBxid(UUID.randomUUID().toString());
        baoXiao.setBxtime(new Date());
       List<Employee> loginUser = (List<Employee>) session.getAttribute("loginUser");
        for (Employee emp:loginUser) {
            baoXiao.setEmpFk(emp.getEid());
        }
       Boolean flag= baoXiaoService.saveInfo(baoXiao);
        return "mybaoxiao-base";
    }
    @RequestMapping(value = "getMyBao",method = RequestMethod.GET)
    @ResponseBody
    public List<BaoXiao> getMyBao(HttpSession session){
        List<Employee> loginUser = (List<Employee>) session.getAttribute("loginUser");
        Integer emFk=0;
        for (Employee emp:loginUser) {
            emFk=emp.getEid();
        }
     return    baoXiaoService.getMyBao(emFk);
    }

}
