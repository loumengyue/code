package com.xiumu.country_manager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 岐神~汤圆
 * @Description:
 * @Attention:
 * @date: 2020/12/25 18:36
 * @version:1.0
 */
public class TimeUtil {
    public static String format(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static Date parse(String time){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {

            date= simpleDateFormat.parse(time);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
