package com.ujiuye.pro.proController;

import com.ujiuye.pro.proBean.Function;
import com.ujiuye.utils.MarkInfo;
import com.ujiuye.utils.SerachInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ujiuye.pro.proService.FunctionService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fun")
public class FunctionController {
@Resource
    private FunctionService functionService;
    @RequestMapping(value = "findmouFk",method = RequestMethod.GET)
    @ResponseBody
    public List<Function> functionService(Integer id) {
        return functionService.functionService(id);
    }
    //添加功能的方法
    @RequestMapping(value = "addFunction",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addFunction(Function function){
       Map<String,Object> HashMap=new HashMap<String, Object>();
        Boolean flag= functionService.addFunction(function);
        if(flag){
            HashMap.put("statusCode",200);
        }else{
            HashMap.put("statusCode",2000);
        }
       return HashMap;
    }
    @RequestMapping(value = "getFun",method = RequestMethod.GET)
    @ResponseBody
    public List<Function> getFun(MarkInfo markInfo) {
        return functionService.getFun(markInfo);
    }
    @RequestMapping(value = "updateFunction",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateFunction(Function function){
        Map<String,Object> HashMap=new HashMap<String, Object>();
        Boolean flag= functionService.updateFunction(function);
        if(flag){
            HashMap.put("statusCode",200);
        }else{
            HashMap.put("statusCode",2000);
        }
        return HashMap;
    }
    @RequestMapping(value = "search",method = RequestMethod.GET)
    @ResponseBody
    public List<Function> search(Integer mark,SerachInfo serachInfo) {
        return functionService.search(mark,serachInfo);
    }

}
