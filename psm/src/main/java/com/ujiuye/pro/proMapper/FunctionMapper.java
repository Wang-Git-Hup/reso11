package com.ujiuye.pro.proMapper;


import java.util.List;

import com.ujiuye.pro.proBean.Function;
import com.ujiuye.pro.proBean.FunctionExample;
import com.ujiuye.utils.MarkInfo;
import com.ujiuye.utils.SerachInfo;
import org.apache.ibatis.annotations.Param;

public interface FunctionMapper {
    long countByExample(FunctionExample example);

    int deleteByExample(FunctionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Function record);

    int insertSelective(Function record);

    List<Function> selectByExample(FunctionExample example);

    Function selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Function record, @Param("example") FunctionExample example);

    int updateByExample(@Param("record") Function record, @Param("example") FunctionExample example);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);

    List<Function> search(@Param("cid") Integer cid, @Param("keyword") String keyword, @Param("orderby") Integer orderby);

    List<Function> functionService(@Param("id")Integer id);

    List<Function> getFun(MarkInfo markInfo);

    List<Function> search(@Param("markInfo") Integer markInfo, @Param("serach") SerachInfo serachInfo);
}