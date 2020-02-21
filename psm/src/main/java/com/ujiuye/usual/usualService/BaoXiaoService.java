package com.ujiuye.usual.usualService;

import com.ujiuye.usual.usualBean.BaoXiao;
import com.ujiuye.utils.MarkInfo;

import java.util.List;

public interface BaoXiaoService {
    List<BaoXiao> getBao(MarkInfo markInfo);

    BaoXiao getOneBaoxiaoInfo(BaoXiao baoXiao);

    Boolean updateBxStatus(BaoXiao baoXiao);

    Boolean saveInfo(BaoXiao baoXiao);

    List<BaoXiao> getMyBao(Integer emFk);
}
