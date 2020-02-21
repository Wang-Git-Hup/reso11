package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Module;
import com.ujiuye.pro.proBean.ModuleExample;
import com.ujiuye.pro.proMapper.ModuleMapper;
import com.ujiuye.utils.MarkInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class MoudelServiceInfo implements  MoudelService {
    @Resource
    private   ModuleMapper moduleMapper;
        //删除模块
    public Boolean deleteModule(Integer[] ids) {
        ModuleExample moduleExample=new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return moduleMapper.deleteByExample(moduleExample)>0;
    }
        //根据条件模糊查询
    public List<Module> search(Integer cid, String keyword, Integer orderby) {
        return moduleMapper.search(cid,keyword,orderby);
    }

    //保存修改的模块
    public Boolean updateModuleById(Module module) {
        return moduleMapper.updateByPrimaryKeySelective(module)>0;
    }
        //根据条件获取模块数据
    public List<Module> getAll(MarkInfo markInfo) {
        return moduleMapper.getAll(markInfo);
    }

    //添加模块
    public Boolean addModule(Module module) {
        return moduleMapper.insert(module)>0;
    }

    public List<Module> findByanalFk(Integer id) {
       return moduleMapper.findByanalFk(id);
    }
}
