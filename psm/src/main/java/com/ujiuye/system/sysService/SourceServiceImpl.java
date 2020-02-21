package com.ujiuye.system.sysService;

import com.ujiuye.system.sysBean.Role;
import com.ujiuye.system.sysBean.Sources;
import com.ujiuye.system.sysMapper.SourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SourceServiceImpl implements  SourceService {
    @Resource
    private SourcesMapper sourcesMapper;

    public List<Sources> showSource(int i) {
        List<Sources> nextSources = sourcesMapper.getNextSources(i);
        Sources sources = nextSources.get(0);
       diguiSource(sources);
        return nextSources;
    }

    public boolean save(Role role) {
        return false;
    }

    public List<Sources> getSecondSourcesListByEid(Integer eid) {
        List<Sources> sources = sourcesMapper.getSourcesByEid(eid,1);
        for (Sources source : sources) {
            Integer id = source.getId();
            List<Sources> menus=sourcesMapper.getSourcesByEid(eid,id);
            source.setChildren(menus);
        }
        return sources;
    }

    //递归
    private void diguiSource(Sources sources) {
        List<Sources> nextSources  = sourcesMapper.getNextSources(sources.getId());
        for (Sources source : nextSources) {
            diguiSource(source);
        }
        sources.setChildren(nextSources);
    }
}
