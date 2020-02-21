package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Function;
import com.ujiuye.utils.MarkInfo;
import com.ujiuye.utils.SerachInfo;

import java.util.List;

public interface FunctionService {
    List<Function> functionService(Integer id);

    Boolean addFunction(Function function);

    List<Function> getFun(MarkInfo markInfo);

    Boolean updateFunction(Function function);

    List<Function> search(Integer markInfo, SerachInfo serachInfo);
}
