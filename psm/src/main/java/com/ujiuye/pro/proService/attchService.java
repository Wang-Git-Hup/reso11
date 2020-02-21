package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Attachment;

import java.util.List;

public interface attchService {
    List<Attachment> filelist();

    void saveInfo(Attachment attachment);
}
