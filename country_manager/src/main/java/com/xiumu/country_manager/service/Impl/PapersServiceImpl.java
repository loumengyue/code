package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.country_manager.mapper.PapersMapper;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.pojo.Papers;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.PapersService;
import com.xiumu.country_manager.utils.Code;
import com.xiumu.country_manager.utils.FileResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@Service
@Slf4j
public class PapersServiceImpl extends ServiceImpl<PapersMapper, Papers> implements PapersService {

    @Autowired
    private PapersMapper papersMapper;
    FileResult fileResult=new FileResult();

    public FileResult fileUpload (MultipartFile file){
        try {
            if (file.isEmpty()) {
                fileResult.setCode(Code.FIlE_NULL);
                return fileResult;
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            String filePath = "D:\\tangyuan\\";
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            //返回文件的绝对地址
            fileResult.setFileUrl(path);
            fileResult.setCode(Code.FILE_UPLOAD_SUCCESS);
           return fileResult;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileResult.setCode(Code.FILL_UPLOAD_FAIL);
        return fileResult;
    }

    public FileResult downloadFile(int id, HttpServletResponse response){
        //通过id获取文件具体信息
        Papers papersById = getPapersById(id);
        String fileName = papersById.getFileName();// 文件名
        if (fileName != null) {
            //设置文件路径
            File file = new File(fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    fileResult.setCode(Code.FILE_DOWN_SUCCESS);
                    return fileResult;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        fileResult.setCode(Code.FILE_DOEN_FAIL);
        return fileResult;
    }

    @Override
    public Page<Papers> getAllPapers(Papers papers, int pageNum, int pageSize) {
        Page <Papers> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Papers> wrapper=new QueryWrapper<>();
        if(papers.getFileName()!=null && papers.getFileName()!=""){
            wrapper.like("file_name",papers.getFileName());
        }
        if(papers.getFileType()!=null && papers.getFileType()!=""){
            wrapper.like("file_type",papers.getFileType());
        }
        return  papersMapper.selectPage(page, wrapper);
    }

    @Override
    public Papers getPapersById(int id) {
        return papersMapper.selectById(id);
    }

    @Override
    public int addPapers(Papers papers) {
        String fileRoute = papers.getFileRoute();
        String fileName = fileRoute.substring(fileRoute.lastIndexOf("\\")+1);
        System.out.println(fileName);
        papers.setFileName(fileName.split("\\.")[0]);
        papers.setFileType(fileName.split("\\.")[1]);
        papers.setFileUpTime(new Date());
       return papersMapper.insert(papers);
    }

    @Override
    public int deletePapers(int id) {
       return  papersMapper.deleteById(id);
    }

    @Override
    public int updatePapers(Papers papers) {
        UpdateWrapper<Papers> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("file_name",papers.getFileName()).set("file_type",papers.getFileType()).set("file_brief",papers.getFileBrief()).eq("file_id",papers.getFileId());
        return papersMapper.update(papers,updateWrapper);
    }

}
