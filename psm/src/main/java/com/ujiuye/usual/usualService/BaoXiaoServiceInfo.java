package com.ujiuye.usual.usualService;
import com.ujiuye.usual.usualBean.BaoXiao;
import com.ujiuye.usual.usualBean.BaoXiaoExample;
import com.ujiuye.usual.usualMapper.BaoXiaoMapper;
import com.ujiuye.utils.MarkInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BaoXiaoServiceInfo implements BaoXiaoService {
    @Resource
    private BaoXiaoMapper baoXiaoMapper;
    //添加报销单
    public Boolean saveInfo(BaoXiao baoXiao) {
        return baoXiaoMapper.insertSelective(baoXiao)>0;
    }
        //获取个人报销单
    public List<BaoXiao> getMyBao(Integer emFk) {
        BaoXiaoExample baoXiaoExample=new BaoXiaoExample();
        BaoXiaoExample.Criteria criteria = baoXiaoExample.createCriteria();
        criteria.andEmpFkEqualTo(emFk);
        return baoXiaoMapper.selectByExample(baoXiaoExample);
    }

    public Boolean updateBxStatus(BaoXiao baoXiao) {
        return baoXiaoMapper.updateByPrimaryKeySelective(baoXiao)>0;
    }

    //根据id获取报销单
    public BaoXiao getOneBaoxiaoInfo(BaoXiao baoXiao) {
        return baoXiaoMapper.selectByPrimaryKey(baoXiao.getBxid());
    }

    //获取报销单数据
    public List<BaoXiao> getBao(MarkInfo markInfo) {
        return baoXiaoMapper.getBao(markInfo);
    }
}
