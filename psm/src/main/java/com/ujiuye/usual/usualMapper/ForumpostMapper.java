package com.ujiuye.usual.usualMapper;

import com.ujiuye.usual.usualBean.Forumpost;

import java.util.List;

public interface ForumpostMapper {
    int deleteByPrimaryKey(Integer forumid);

    int insert(Forumpost record);

    int insertSelective(Forumpost record);

    Forumpost selectByPrimaryKey(Integer forumid);

    int updateByPrimaryKeySelective(Forumpost record);

    int updateByPrimaryKey(Forumpost record);

    List<Forumpost> getForamList();
}