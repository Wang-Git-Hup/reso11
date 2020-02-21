package com.ujiuye.usual.usualController;

import com.ujiuye.usual.usualBean.Notice;
import com.ujiuye.utils.MarkInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ujiuye.usual.usualService.NoticeService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/not")
public class NoticeController {
    @Resource
  private   NoticeService noticeService;
    @RequestMapping(value = "showNotice",method = RequestMethod.GET)
    @ResponseBody
    public List<Notice> showNotice(MarkInfo markInfo){
            return  noticeService.showNotice(markInfo);
    }
    @RequestMapping(value = "saveInfo",method = RequestMethod.POST)
    public String  saveInfo(Notice notice){
         boolean flag=noticeService.saveInfo(notice);
         return "notice";
    }
    @RequestMapping(value = "getLimitList",method = RequestMethod.GET)
    @ResponseBody
    public List<Notice> getLimitList(){
        return  noticeService.getLimitList();
    }

}
