package com.xiumu.country_manager.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Papers;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.service.PapersService;
import com.xiumu.country_manager.utils.FileResult;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *文件上传下载
 */
@RestController
@CrossOrigin
public class PapersController {


    @Autowired
    private PapersService papersService;

    private static final Logger log = LoggerFactory.getLogger(PapersController.class);

    /**
     * 上传单个指定文件
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public FileResult fileUpload(MultipartFile file){
        FileResult fileResult = papersService.fileUpload(file);
        return fileResult;
    }

    /**
     * 下载指定文件 
     * @param response
     * @return
     */
    @RequestMapping("/download")
    public FileResult downloadFile(int id, HttpServletResponse response){
        FileResult fileResult = papersService.downloadFile(id, response);
        return fileResult;
    }


    @PostMapping("/getAllPapers")
    public Result getAllPapers(@RequestBody PageArgsPro<Papers> papersPageArgsPro) {
        Papers papers=papersPageArgsPro.getCondition();
        int pageNum=papersPageArgsPro.getPageNum();
        int pageSize = papersPageArgsPro.getPageSize();
        Page<Papers> allPapers = papersService.getAllPapers(papers, pageNum, pageSize);

        return ResultStatusUtil.JudgeStatus(allPapers);
    }

    @GetMapping("/getPapersById")
    public Result getPapersById(Integer id) {
        Papers papersById = papersService.getPapersById(id);
        return ResultStatusUtil.JudgeStatus(papersById);
    }

    @GetMapping("/deletePapers")
    public Result deletePapers(Integer id) {
        int i = papersService.deletePapers(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/addFile")
    public Result addPapers(@RequestBody Papers papers) {
        int i = papersService.addPapers(papers);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updatePapers")
    public Result updatePapers(@RequestBody Papers papers) {
        int i = papersService.updatePapers(papers);
        return ResultStatusUtil.JudgeNum(i);
    }
}
