package com.hutool.use.service.impl;


import com.hutool.use.service.HttpPostService;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/7 9:30
 */
public class HttpPostServiceImpl implements HttpPostService {

    @Override
    public void sendPost(){
        String sscKey = "SCT47838TnjnuJTMBHNAJzwl0HYKfudHA";
        String url = "https://sctapi.ftqq.com/" + sscKey + ".send";
        Map<String,String> map = new HashMap<>();
        map.put("title","Server over!");
        String param ="";
    }
}
