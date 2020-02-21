package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Module;
import com.ujiuye.utils.MarkInfo;

import java.util.List;

public interface MoudelService {
    List<Module> findByanalFk(Integer id);

    Boolean addModule(Module module);

    List<Module> getAll(MarkInfo markInfo);

    Boolean updateModuleById(Module module);

    Boolean deleteModule(Integer[] ids);

    List<Module> search(Integer cid, String keyword, Integer orderby);
}
