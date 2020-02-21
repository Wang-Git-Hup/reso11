package com.ujiuye.duibiao.duiMapper;


import com.ujiuye.duibiao.duiBean.Datacollect;

import java.util.List;

public interface DatacollectMapper {
    int deleteByPrimaryKey(Integer daid);

    int insert(Datacollect record);

    int insertSelective(Datacollect record);

    Datacollect selectByPrimaryKey(Integer daid);

    int updateByPrimaryKeySelective(Datacollect record);

    int updateByPrimaryKey(Datacollect record);

}