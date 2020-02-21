package com.ujiuye.pro.proService;

import com.ujiuye.pro.proBean.Attachment;
import com.ujiuye.pro.proBean.AttachmentExample;
import com.ujiuye.pro.proMapper.AttachmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class attchServiceInfo implements  attchService {
    @Resource
    private AttachmentMapper attachmentMapper;
    public List<Attachment> filelist() {
        AttachmentExample attachmentExample=new AttachmentExample();
        return attachmentMapper.getAll();
    }
        //上传文件
    public void saveInfo(Attachment attachment) {
        attachmentMapper.insert(attachment);
    }
}
