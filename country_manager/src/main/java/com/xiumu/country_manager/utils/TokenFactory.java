package com.xiumu.country_manager.utils;


import com.xiumu.country_manager.pojo.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 岐神~汤圆
 * @Description:  jwt中生成Token的方法
 * @Attention:
 * @date: 2021/3/3 19:19
 * @version:1.0
 */
public class TokenFactory {
    public String getToken(User user) {
        //生成token
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", user.getUserId());

        // 生成token
        String token = Jwts.builder()
                .setClaims(claims) //payload，存放数据的位置，不能放置敏感数据，如：密码等
                .signWith(SignatureAlgorithm.HS256, "abc") //设置加密方法和加密盐
                .setExpiration(new DateTime().plusHours(12).toDate()) //设置过期时间，12小时后过期
                .compact();
        return token;
    }
}
