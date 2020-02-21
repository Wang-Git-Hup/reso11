package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Function;
import com.ujiuye.pro.proMapper.FunctionMapper;
import com.ujiuye.utils.MarkInfo;
import com.ujiuye.utils.SerachInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FunctionServiceInfo implements  FunctionService {
    @Resource
    private FunctionMapper functionMapper;
    public List<Function> functionService(Integer id) {
        return functionMapper.functionService(id);
    }
    //模糊查询
    public List<Function> search(Integer markInfo, SerachInfo serachInfo) {
        return functionMapper.search(markInfo,serachInfo);
    }

    public Boolean updateFunction(Function function) {
        return functionMapper.updateByPrimaryKeySelective(function)>0;
    }

    //获取Function数据
    public List<Function> getFun(MarkInfo markInfo) {
        return functionMapper.getFun(markInfo);
    }

    //添加功能
    public Boolean addFunction(Function function) {

        return functionMapper.insertSelective(function)>0;
    }
}
