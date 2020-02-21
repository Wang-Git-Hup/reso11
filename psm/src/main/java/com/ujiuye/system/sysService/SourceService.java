package com.ujiuye.system.sysService;

import com.ujiuye.system.sysBean.Role;
import com.ujiuye.system.sysBean.Sources;

import java.util.List;

public interface SourceService {
    List<Sources> showSource(int i);
    boolean save(Role role);

    List<Sources> getSecondSourcesListByEid(Integer eid);
}
