package com.ujiuye.usual.usualService;

import com.ujiuye.usual.usualBean.Forumpost;
import com.ujiuye.usual.usualMapper.ForumpostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsualServiceImpl implements UsualService {
    @Resource
    private ForumpostMapper forumpostMapper;
        //主页面4条帖子
    public List<Forumpost> getForamList() {
        return forumpostMapper.getForamList();
    }

    //添加帖子
    public Boolean addForumPost(Forumpost forumpost) {
        return forumpostMapper.insertSelective(forumpost)>0;
    }
}
