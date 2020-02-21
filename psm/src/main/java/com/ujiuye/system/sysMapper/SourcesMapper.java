package com.ujiuye.system.sysMapper;


import com.ujiuye.system.sysBean.Sources;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourcesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sources record);

    int insertSelective(Sources record);

    Sources selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sources record);

    int updateByPrimaryKey(Sources record);

    //获取我们的根资源
     Sources   getRootSources();
     //根据我们的资源的id 获取当前资源的下一级资源
     List<Sources> getNextSources(Integer pid);
     List<Sources> getSourceByRoleid(Integer roleid);

    List<Sources> getSourcesByEid(@Param("eid") Integer eid, @Param("pid") int i);
}