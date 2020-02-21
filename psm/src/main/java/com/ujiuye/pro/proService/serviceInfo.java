package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Project;
import com.ujiuye.pro.proBean.ProjectExample;
import com.ujiuye.pro.proMapper.ProjectMapper;
import com.ujiuye.utils.MarkInfo;
import com.ujiuye.utils.SerachInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
@Service
public class serviceInfo implements service {
        @Resource
        private ProjectMapper projectMapper;

    public boolean addProject(Project p) {
        return projectMapper.insert(p)>0;
    }

    public Project getProById(Integer proid) {
        return projectMapper.selectByPrimaryKey(proid);
    }

    public Boolean updataPro(Project project) {
        return projectMapper.updateByPrimaryKey(project)>0;
    }

    public Boolean deleteProject(Integer[] ids) {
        ProjectExample projectExample=new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andPidIn(Arrays.asList(ids));
        return projectMapper.deleteByExample(projectExample)>0;
    }
    //查询还已经添加需求的项目
    public List<Project> projetListWithinAnalysis(MarkInfo markInfo) {
        return projectMapper.projetListWithinAnalysis(markInfo);
    }
        //分页功能
    public List<Project> getAllPage(SerachInfo serachInfo) {
        return projectMapper.getAllPage(serachInfo);
    }

    //查询还没有添加需求的项目
    public List<Project> projetListWithNotAnalysis() {
        return projectMapper.projetListWithNotAnalysis();
    }

    public List<Project> showProAndOtherInfo(MarkInfo markInfo) {
        return projectMapper.showProAndOtherInfo(markInfo.getMark());
    }

    public List<Project> getAll(Integer cid, String keyword, Integer orderby) {
        return projectMapper.getAll(cid, keyword, orderby);

    }
}
