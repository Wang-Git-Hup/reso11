package com.ujiuye.usual.usualService;

import com.ujiuye.usual.usualBean.Notice;
import com.ujiuye.utils.MarkInfo;

import java.util.List;

public interface NoticeService {
    List<Notice> showNotice(MarkInfo markInfo);

    boolean saveInfo(Notice notice);

    List<Notice> getLimitList();
}
