package com.ujiuye.pro.proMapper;


import java.util.List;

import com.ujiuye.pro.proBean.Project;
import com.ujiuye.pro.proBean.ProjectExample;
import com.ujiuye.utils.MarkInfo;
import com.ujiuye.utils.SerachInfo;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    long countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> search(@Param("cid") Integer cid, @Param("keyword") String keyword, @Param("orderby") Integer orderby);

    List<Project> projetListWithNotAnalysis();

    List<Project> getAll(@Param("cid") Integer cid, @Param("keyword")String keyword,@Param("orderby")Integer orderby);

    List<Project> showProAndOtherInfo(@Param("mark") Integer mark);

    List<Project> projetListWithinAnalysis(MarkInfo markInfo);

    List<Project> getAllPage(SerachInfo serachInfo);
}