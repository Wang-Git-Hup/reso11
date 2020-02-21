package com.ujiuye.duibiao.duiMapper;


import com.ujiuye.duibiao.duiBean.Indexvalue;

import java.util.List;

public interface IndexvalueMapper {
    int deleteByPrimaryKey(Integer inId);

    int insert(Indexvalue record);

    int insertSelective(Indexvalue record);

    Indexvalue selectByPrimaryKey(Integer inId);

    int updateByPrimaryKeySelective(Indexvalue record);

    int updateByPrimaryKey(Indexvalue record);

    List<Indexvalue> showAllIndexValue();
}