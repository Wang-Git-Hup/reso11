package com.ujiuye.pro.proController;

import com.ujiuye.pro.proBean.Analysis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 import com.ujiuye.pro.proService.AnalysService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("analys")
public class AnalysController {
    @Resource
    private AnalysService analysService;
    //根据ID查询单条数据
    @RequestMapping(value = "showAnalys",method = RequestMethod.GET)
    @ResponseBody
    public Analysis showAnalys(Integer id){
        return analysService.showAnalys(id);
    }
    //查询所有的需求
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Analysis> getAll(){
        return analysService.getAll();
    }
    //保存编辑的数据
    @RequestMapping(value = "updateAnalysis",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateAnalysis(Analysis analysis){
        Map<String,Object> map =new HashMap<String, Object>();
        Boolean flag=analysService.updateAnalysis(analysis);
        if(flag){
            map.put("statusCode",200);
        }else{
            map.put("statusCode",500);
        }
        return map;
    }

    //给项目添加需求
    @RequestMapping(value = "addAnalysis",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addAnalysis(Analysis analysis){
        analysis.setAddtime(new Date());
        analysis.setUpdatetime(new Date());
        Map<String,Object> map =new HashMap<String, Object>();
        Boolean flag=analysService.addAnalysis(analysis);
        if(flag){
            map.put("statusCode",200);
        }else{
            map.put("statusCode",500);
        }
        return map;
    }
    //根据条件进行模糊查询
    @RequestMapping(value = "search",method = RequestMethod.GET)
    @ResponseBody
    public List<Analysis> search(Integer cid ,String keyword,String orderby){

        return analysService.search(cid,keyword,orderby);
    }
    @RequestMapping(value = "deleteByIds",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deleteByIds( @RequestParam("ids[]") Integer [] ids){

        Map<String,Object> map =new HashMap<String, Object>();
        Boolean flag=analysService.deleteByIds(ids);
        if(flag){
            map.put("statusCode",200);
        }else{
            map.put("statusCode",500);
        }
        return map;
    }

}
