package com.ujiuye.usual.usualMapper;


import java.util.List;

import com.ujiuye.usual.usualBean.BaoXiao;
import com.ujiuye.usual.usualBean.BaoXiaoExample;
import com.ujiuye.utils.MarkInfo;
import org.apache.ibatis.annotations.Param;

public interface BaoXiaoMapper {
    long countByExample(BaoXiaoExample example);

    int deleteByExample(BaoXiaoExample example);

    int deleteByPrimaryKey(String bxid);

    int insert(BaoXiao record);

    int insertSelective(BaoXiao record);

    List<BaoXiao> selectByExample(BaoXiaoExample example);

    BaoXiao selectByPrimaryKey(String bxid);

    int updateByExampleSelective(@Param("record") BaoXiao record, @Param("example") BaoXiaoExample example);

    int updateByExample(@Param("record") BaoXiao record, @Param("example") BaoXiaoExample example);

    int updateByPrimaryKeySelective(BaoXiao record);

    int updateByPrimaryKey(BaoXiao record);

    List<BaoXiao> getBao(MarkInfo markInfo);
}