package com.ujiuye.pro.proMapper;


import java.util.List;

import com.ujiuye.pro.proBean.Module;
import com.ujiuye.pro.proBean.ModuleExample;
import com.ujiuye.utils.MarkInfo;
import org.apache.ibatis.annotations.Param;

public interface ModuleMapper {
    long countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> search(@Param("cid") Integer cid, @Param("keyword") String keyword, @Param("orderby") Integer orderby);


    List<Module> findByanalFk(@Param("id") Integer id);

    List<Module> getAll(MarkInfo markInfo);
}