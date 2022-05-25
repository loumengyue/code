package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.News;
import com.xiumu.country_manager.pojo.Population;

import java.util.List;

public interface NewsService extends IService<News> {
    /**
     * 查询所有
     * @return
     */
    PageInfo getAllNews(News news,int start, int pageSize);

    /**
     * 根据id获取指定
     * @param id
     * @return
     */
    News getNewsById(int id);

    /**
     * 添加
     * @param news
     * @return
     */
    int addNews(News news);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteNews(int id);

    /**
     * 修改
     * @param news
     * @return
     */
    int updateNews(News news);

    List<News> getNewsList();//新加的lmy，改后5/4
}
