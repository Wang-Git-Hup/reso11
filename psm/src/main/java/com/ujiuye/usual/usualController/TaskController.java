package com.ujiuye.usual.usualController;

import com.ujiuye.usual.usualBean.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import com.ujiuye.usual.usualService.TaskService;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Resource
    private TaskService taskService;
    //添加任务
    @RequestMapping(value = "saveTask",method = RequestMethod.POST)
    public String saveTask(Task task){
        task.setEmpFk2(2);
       boolean flag= taskService.saveTask(task);
        return "task";
    }
}
