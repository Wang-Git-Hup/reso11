package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Project;
import com.ujiuye.utils.MarkInfo;
import com.ujiuye.utils.SerachInfo;

import java.util.List;

public interface service {
    List<Project> getAll(Integer cid, String keyword, Integer orderby);

    boolean addProject(Project p);

    Project getProById(Integer proid);

    Boolean updataPro(Project project);

    Boolean deleteProject(Integer[] ids);

    List<Project> showProAndOtherInfo(MarkInfo markInfo);

    List<Project> projetListWithNotAnalysis();

    List<Project> projetListWithinAnalysis(MarkInfo markInfo);

    List<Project> getAllPage(SerachInfo serachInfo);
}
