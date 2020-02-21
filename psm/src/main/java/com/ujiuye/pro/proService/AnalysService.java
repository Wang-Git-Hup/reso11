package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Analysis;

import java.util.List;

public interface AnalysService {
    Analysis showAnalys(Integer id);

    List<Analysis> getAll();

    Boolean updateAnalysis(Analysis analysis);

    Boolean addAnalysis(Analysis analysis);

    List<Analysis> search(Integer cid, String keyword, String orderby);

    Boolean deleteByIds(Integer[] ids);
}
