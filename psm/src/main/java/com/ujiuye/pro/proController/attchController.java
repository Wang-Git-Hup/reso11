package com.ujiuye.pro.proController;

import com.ujiuye.pro.proBean.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.aspectj.util.FileUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ujiuye.pro.proService.attchService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/attch")
public class attchController {
    @Resource
    private attchService attchService;
    @RequestMapping(value = "filelist" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Attachment> filelist(){
        return attchService.filelist();
    }
    //上传文件
   /* @RequestMapping(value = "saveInfo" ,method = RequestMethod.POST)
    public  String saveInfo(Attachment attachment, MultipartFile file, HttpSession session){
        //上传的路径
        String realPath = session.getServletContext().getRealPath("/upload");
        //获取文件的文件名
        String originalFilename = file.getOriginalFilename();
        //获取UUID
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        //处理文件明
        String filename=s+originalFilename;
        //判断上传路径是否存在
        File file1=new File(realPath);
        if(!file1.exists()){
            file1.mkdir();
        }
        try {
            //写入文件
            file.transferTo(new File(realPath + "/" + filename));
            attachment.setPath(realPath + '/' + filename);
            attchService.saveInfo(attachment);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "project-file";
    }*/
   //上传文件
    @RequestMapping(value = "saveInfo" ,method = RequestMethod.POST)
    public  String saveInfo(Attachment attachment, MultipartFile file, HttpSession session){
        try {
            //1.获取上传的路径
        String realPath = session.getServletContext().getRealPath("/upload");
                //2.获取文件的全名
        String originalFilename = file.getOriginalFilename();
                //3.获取UUID
        String s = UUID.randomUUID().toString().replaceAll("-", "");
                //4.处理文件名
        originalFilename=s+originalFilename;
                //5.判断路径是否存在
        File file1=new File(realPath);
        if(!file1.exists()){
            file1.mkdir();
        }
                //6.上传文件
            file.transferTo(new File(realPath+"/"+originalFilename));
            attachment.setPath(originalFilename);
            attchService.saveInfo(attachment);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return   "project-file";
    }
    //文件下载
    @RequestMapping(value = "download")
   public ResponseEntity<byte []> download(String path,HttpSession session){
        String realPath = session.getServletContext().getRealPath("/upload");
        File file=new File(realPath+"/"+path);
        try {
            //使用硬编码解决下载文件名乱码问题
            String ms=new String(path.getBytes("UTF-8"),"iso-8859-1");
            //设置响应头信息
            HttpHeaders httpHeaders=new HttpHeaders();
            //设置文件名
           httpHeaders.setContentDispositionFormData("abc",ms);
            //设置头的类型
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //返回
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders,HttpStatus.OK);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return  null;
    }
    //导出excle
    @RequestMapping(value = "outExcle")
    public String outExcle(HttpServletResponse response )throws IOException{
        response.setCharacterEncoding("UTF-8");
        List<Attachment> filelist = attchService.filelist();
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("附件表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("序号");
        titleRow.createCell(1).setCellValue("附件名称");
        titleRow.createCell(2).setCellValue("所属项目");
        titleRow.createCell(3).setCellValue("附件个数");
        titleRow.createCell(4).setCellValue("上传时间");

//	        titleRow.createCell(9).setCellValue("创建时间 ");
//	        titleRow.createCell(10).setCellValue("更新时间");
        //遍历将数据放到excel列中
        for (Attachment user : filelist) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(user.getId());
            dataRow.createCell(1).setCellValue(user.getAttname());
            dataRow.createCell(2).setCellValue(user.getProFk());
            dataRow.createCell(3).setCellValue(user.getAttname());
            dataRow.createCell(4).setCellValue(new Date());

        }
        String fileName = "test.xls";
        response.setHeader("Content-disposition", "attachment;filename="
                + new String(fileName.getBytes("gb2312"), "ISO8859-1"));//设置文件头编码格式
        response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");//设置类型
        response.setHeader("Cache-Control", "no-cache");//设置头
        response.setDateHeader("Expires", 0);//设置日期头
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
        return  null;
    }

}
