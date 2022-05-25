package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Papers;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.utils.FileResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface PapersService extends IService<Papers> {

    /**
     * 文件上传
     * @param file
     * @return
     */
    FileResult fileUpload (MultipartFile file);

    /**
     * 文件下载
     * @param id
     * @param response
     * @return
     */
    FileResult downloadFile(int id, HttpServletResponse response);

    /**
     * 查询所有
     * @return
     */
    Page<Papers> getAllPapers(Papers papers, int pageNum, int pageSize);

    /**
     * 根据id获取指定
     * @param id
     * @return
     */
    Papers getPapersById(int id);

    /**
     * 添加
     * @param papers
     * @return
     */
    int addPapers(Papers papers);

    /**
     * 删除
     * @param id
     * @return
     */
    int deletePapers(int id);

    /**
     * 修改
     * @param papers
     * @return
     */
    int updatePapers(Papers papers);
}
