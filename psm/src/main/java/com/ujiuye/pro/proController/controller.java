package com.ujiuye.pro.proController;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.pro.proBean.Project;
import com.ujiuye.utils.MarkInfo;
import com.ujiuye.utils.SerachInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ujiuye.pro.proService.service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pro")
public class controller {
         @Resource
            private  service service;
         //查询项目及模糊查询
         @RequestMapping("projetList")
         @ResponseBody
        public List<Project> projetList(Integer cid,String keyword,Integer orderby){
             List<Project> list= service.getAll( cid, keyword, orderby);
        return  list;
        }
    @RequestMapping(value = "Page",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Project> Page(HttpSession session,SerachInfo serachInfo, Integer status,
                                  @RequestParam(value ="pageNum",defaultValue = "1") Integer pageNum){
                if(serachInfo.getKeyword().length()>0||status!=null){
                    session.removeAttribute("serach");
                }
                List<Project> list=null;
                PageHelper.startPage(pageNum,3);
                SerachInfo  serach= (SerachInfo)session.getAttribute("serach");
                if(serach!=null){
                    list= service.getAllPage(serach);
                }else{
                    session.setAttribute("serach",serachInfo);
                    list= service.getAllPage(serachInfo);
                }
                         PageInfo<Project> projectPageInfo=new PageInfo<Project>(list);
                        return  projectPageInfo;
    }

        //添加项目
    @RequestMapping(value = "addProject",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addProject(Project p){
             Map<String,Object> map=new HashMap<String, Object>();
       boolean flag= service.addProject(p);
       if(flag){
           map.put("statusCode",200);
       }else{
           map.put("statusCode",1000);
        }
        return map;
    }
    //回显数据
    @RequestMapping(value = "getProById",method = RequestMethod.GET)
    @ResponseBody
    public Project getProById(Integer proid){
       return  service.getProById(proid);
    }
    //修改项目、
    @RequestMapping(value = "updataPro",method = RequestMethod.PUT)
    @ResponseBody
    public Boolean updataPro(Project project){
        System.out.println(project);
        return  service.updataPro(project);
    }
    //删除项目
    @RequestMapping(value = "deleteProject",method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean deleteProject(@RequestParam("ids[]") Integer [] ids){
        System.out.println(ids[0]);
        return  service.deleteProject(ids);
    }
    @RequestMapping(value = "showProAndOtherInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> showProAndOtherInfo(MarkInfo markInfo){
            return  service.showProAndOtherInfo(markInfo);
    }
    //查询没有添加需求的项目
    @RequestMapping(value = "projetListWithNotAnalysis",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> projetListWithNotAnalysis(){
        return  service.projetListWithNotAnalysis();
    }
    //查询已经添加需求的项目
    @RequestMapping(value = "projetListWithinAnalysis",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> projetListWithinAnalysis(MarkInfo markInfo){
        return  service.projetListWithinAnalysis(markInfo);
    }
}
