package com.ujiuye.usual.usualService;

import com.ujiuye.usual.usualBean.Forumpost;

import java.util.List;

public interface UsualService {
    Boolean addForumPost(Forumpost forumpost);

    List<Forumpost> getForamList();
}
