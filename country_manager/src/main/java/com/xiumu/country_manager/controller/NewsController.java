package com.xiumu.country_manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Helper;
import com.xiumu.country_manager.pojo.News;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.service.NewsService;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  消息
 */
@RestController
@CrossOrigin
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/getAllNews")
    public Result getAllNews(@RequestBody PageArgsPro <News> newsPageArgsPro) {
        News news = newsPageArgsPro.getCondition();
        int pageNum = newsPageArgsPro.getPageNum();
        int pageSize = newsPageArgsPro.getPageSize();
        PageInfo allNews = newsService.getAllNews(news,pageNum, pageSize);
        return ResultStatusUtil.JudgeStatus(allNews);
    }

    @PostMapping("/getNewsList")
    public Result getNewsList(){
        List<News> all=newsService.getNewsList();
        Map<String, Object> res = new HashMap<String, Object>();
        String flag="getNewsListOK";
        res.put("flag",flag);
        res.put("newsList",all);
        return ResultStatusUtil.JudgeStatus(res);
    }//新加的lmy，改后5/4

    @GetMapping("/getNewsById")
    public Result getNewsById(Integer id) {
        News newsById = newsService.getNewsById(id);
        return ResultStatusUtil.JudgeStatus(newsById);
    }

    @GetMapping("/deleteNews")
    public Result deleteNews(Integer id) {
        int i = newsService.deleteNews(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/addNews")
    public Result addNews(@RequestBody News news) {
        int i = newsService.addNews(news);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updateNews")
    public Result updateNews(@RequestBody News news) {
        int i = newsService.updateNews(news);
        return ResultStatusUtil.JudgeNum(i);
    }
}
