package com.hutool.use.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/7 9:22
 */
@RestController("hutool/http")
public class HttpController {

    @PostMapping(value = "/sent")
    public void sendPost(){

    }
}
