package com.ujiuye.usual.usualService;

import com.ujiuye.usual.usualBean.Task;
import com.ujiuye.usual.usualMapper.TaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskServiceInfo  implements  TaskService{
    @Resource
   private TaskMapper taskMapper;
    public boolean saveTask(Task task) {
        return taskMapper.insertSelective(task)>0;
    }
}
