package com.ujiuye.system.sysController;

import com.ujiuye.system.sysBean.Role;
import com.ujiuye.system.sysBean.Sources;
import com.ujiuye.system.sysService.SourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("sys")
public class SourceController {
    @Resource
    private  SourceService sourceService;
    //展示权限树
    @RequestMapping(value = "showSource",method = RequestMethod.POST)
    @ResponseBody
    public List<Sources> showSource(){
      return   sourceService.showSource(0);
    }
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public boolean save(Role role ,@RequestParam("ids[]") Integer [] ids){
        return   sourceService.save(role);
    }
}
