package com.dening.learn.sun.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wudening
 * @Description: 对外提供API接口控制器样例
 * @Date: 2021/4/21 9:16 上午
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/get/example")
    public String getDemoMethod(@RequestParam String name) {
        return "Hello " + name + ",Welcome to demo controller";
    }

}
