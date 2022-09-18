package com.xxl.job.executor.mvc.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/sample")
public class IndexController {

    @RequestMapping("/main")
    @ResponseBody
    String index() {
        return "xxl job executor running.";
    }

}