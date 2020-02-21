package com.ujiuye.usual.usualController;

import com.ujiuye.emp.empBean.Employee;
import com.ujiuye.usual.usualBean.Forumpost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ujiuye.usual.usualService.UsualService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/usual")
public class UsualController {
                @Resource
            private UsualService usualService;
        //发布帖子
    @RequestMapping(value = "addForumPost",method = RequestMethod.POST)
    public  String addForumPost(Forumpost forumpost, HttpSession session){
       List<Employee> loginUser = (List<Employee>) session.getAttribute("loginUser");
        for (Employee e:loginUser) {
            forumpost.setEmpFk3(e.getEid());
        }
        Boolean flag=usualService.addForumPost(forumpost);
        return "forum";
    }
    @RequestMapping(value = "getForamList",method = RequestMethod.GET)
    @ResponseBody
    public  List<Forumpost> getForamList(){
        return  usualService.getForamList();
    }



}
