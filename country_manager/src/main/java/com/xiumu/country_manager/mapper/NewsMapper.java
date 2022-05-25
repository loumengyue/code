package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.News;
import com.xiumu.country_manager.pojo.Village;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface NewsMapper extends BaseMapper<News> {
    List<News> getAllNews(News news);
    News getNewsById(int id);
    int addNews(News news);
    int deleteNews(int id);
    int updateNews(News news);

    @Select("Select * from news_manage")
    List<News> getNewsList();//新加的lmy，改后5/4
}
