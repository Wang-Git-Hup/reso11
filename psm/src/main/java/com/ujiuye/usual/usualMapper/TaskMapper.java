package com.ujiuye.usual.usualMapper;



import com.ujiuye.usual.usualBean.Task;
import com.ujiuye.utils.MarkInfo;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> getTaskByEid(MarkInfo markInfo);
}