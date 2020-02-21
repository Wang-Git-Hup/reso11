package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Analysis;
import com.ujiuye.pro.proBean.AnalysisExample;
import com.ujiuye.pro.proMapper.AnalysisMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class AnalysServiceInfo implements  AnalysService{
    @Resource
    private AnalysisMapper analysisMapper;
    public Analysis showAnalys(Integer id) {
        return analysisMapper.selectByPrimaryKey(id);
    }
            //查询所有的需求
    public List<Analysis> getAll() {
        AnalysisExample analysisExample=new AnalysisExample();
        return analysisMapper.selectByExample(analysisExample);
    }

    public Boolean updateAnalysis(Analysis analysis) {
      return   analysisMapper.updateByPrimaryKeySelective(analysis)>0;
    }
        //根据主键删除
    public Boolean deleteByIds(Integer[] ids) {
        AnalysisExample analysisExample=new AnalysisExample();
        AnalysisExample.Criteria criteria = analysisExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return analysisMapper.deleteByExample(analysisExample)>0;
    }

    public List<Analysis> search(Integer cid, String keyword, String orderby) {
                       AnalysisExample analysisExample=new AnalysisExample();
        AnalysisExample.Criteria criteria = analysisExample.createCriteria();
        AnalysisExample.Criteria criteria2 = analysisExample.createCriteria();
                    if(cid==0){
                        criteria.andPronameLike("%"+keyword+"%");
                        criteria2.andTitleLike("%"+keyword+"%");
                        analysisExample.or(criteria2);
                        }else if(cid==1){
                        criteria.andPronameLike("%"+keyword+"%");
                    }else{
                        criteria2.andTitleLike("%"+keyword+"%");
                    }
                    if(orderby.equals("1")){
                        analysisExample.setOrderByClause("addtime");
                    }
        return analysisMapper.selectByExample(analysisExample);
    }

    //添加需求
    public Boolean addAnalysis(Analysis analysis) {
        return analysisMapper.insertSelective(analysis)>0;
    }
}
