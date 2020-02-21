package com.ujiuye.usual.usualService;

import com.ujiuye.usual.usualBean.Notice;
import com.ujiuye.usual.usualBean.NoticeExample;
import com.ujiuye.usual.usualMapper.NoticeMapper;
import com.ujiuye.utils.MarkInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceInfo implements NoticeService{

    @Resource
    private NoticeMapper noticeMapper;
    //主页显示3条数据
    public List<Notice> getLimitList() {
        return noticeMapper.getLimitList();
    }

    public boolean saveInfo(Notice notice) {
        notice.setNdate(new Date());
        return noticeMapper.insertSelective(notice)>0;
    }

    public List<Notice> showNotice(MarkInfo markInfo) {
        NoticeExample example=new NoticeExample();

        return noticeMapper.selectByExample(example);
    }
}
