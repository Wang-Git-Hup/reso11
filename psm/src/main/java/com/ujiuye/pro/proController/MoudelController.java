package com.ujiuye.pro.proController;

import com.ujiuye.pro.proBean.Analysis;
import com.ujiuye.pro.proBean.Module;
import com.ujiuye.utils.MarkInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ujiuye.pro.proService.MoudelService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mou")
public class MoudelController {
@Resource
private MoudelService moudelService;
@RequestMapping(value = "findByanalFk",method = RequestMethod.GET)
@ResponseBody
    public List<Module> findByanalFk(Integer id){
   return moudelService.findByanalFk(id);
}
//添加模块
    @RequestMapping(value = "addModule",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addModule(Module module){
            Map<String,Object> map=new HashMap<String, Object>();
            Boolean flag=moudelService.addModule(module);
            if(flag){
                map.put("statusCode",200);
            }else {
                map.put("statusCode",500);
            }
        return map;
    }
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    @ResponseBody
    public  List<Module> getAll(MarkInfo markInfo){
            return moudelService.getAll(markInfo);
    }

    //保存模块修改
    @RequestMapping(value = "updateModuleById",method = RequestMethod.PUT)
    @ResponseBody
    public   Map<String,Object>  updateModuleById(Module module){
        Map<String,Object> map=new HashMap<String, Object>();
        Boolean flag=moudelService.updateModuleById(module);
        if(flag){
            map.put("statusCode",200);
        }else {
            map.put("statusCode",500);
        }
        return  map;
    }

    //删除模块
    @RequestMapping(value = "deleteModule",method = RequestMethod.DELETE)
    @ResponseBody
    public   Map<String,Object>  deleteModule(@RequestParam("ids[]") Integer [] ids){
        Map<String,Object> map=new HashMap<String, Object>();
        Boolean flag=moudelService.deleteModule(ids);
        if(flag){
            map.put("statusCode",200);
        }else {
            map.put("statusCode",500);
        }
        return  map;
    }
    @RequestMapping(value = "search",method = RequestMethod.GET)
    @ResponseBody
    public List<Module> search(Integer cid , String keyword, Integer orderby){
        return moudelService.search(cid,keyword,orderby);
    }

}
