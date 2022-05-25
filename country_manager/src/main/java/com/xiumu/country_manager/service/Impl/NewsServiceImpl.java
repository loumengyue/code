package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.NewsMapper;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.pojo.News;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public PageInfo getAllNews(News news,int start, int pageSize) {
        PageHelper.startPage(start,pageSize);
        List<News> allNews = newsMapper.getAllNews(news);
        PageInfo<News> pageInfo=new PageInfo(allNews);
        return pageInfo;
    }

    @Override
    public  List<News> getNewsList(){
        return newsMapper.getNewsList();
    }//新加的lmy，改后5/4

    @Override
    public News getNewsById(int id) {
        News newsById = newsMapper.getNewsById(id);
        return newsById;
    }

    @Override
    public int addNews(News news) {

        return newsMapper.addNews(news);
    }

    @Override
    public int deleteNews(int id) {
        return newsMapper.deleteNews(id);
    }

    @Override
    public int updateNews(News news) {
        return newsMapper.updateNews(news);
    }
}
