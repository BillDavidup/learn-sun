package com.dening.learn.sun.web.controller;

import com.david.learn.first.service.JsonConvertService;
import com.dening.learn.sun.common.pojo.Person;
import com.dening.learn.sun.web.param.DemoObjParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: wudening
 * @Description: 对外提供API接口控制器样例
 * @Date: 2021/4/21 9:16 上午
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Autowired
    JsonConvertService jsonConvertService;

    /**
     * mvc:get方法
     *
     * @param name
     * @return
     */
    @GetMapping("/get/example")
    public String getDemoMethod(@RequestParam String name) {
        return "Hello " + name + ",Welcome to demo controller";
    }

    /**
     * mvc:post方法
     *
     * @param userId
     * @param userName
     * @return
     */
    @PostMapping("/post/example")
    public String postDemoMethod(@RequestParam(required = false, name = "uid", value = "uid") Long userId, @RequestParam String userName) {
        String helloMessage = "";
        if (!Objects.isNull(userId)) {
            helloMessage = "Hello " + userId + " " + userName + " ,Welcome to demo controller!";
        } else {
            helloMessage = "Hello " + userName + " ,Welcome to demo controller!";
        }
        return helloMessage;
    }

    /**
     * post:参数用对象来接收
     *
     * @param demoObjParam
     * @return
     */
    @PostMapping("/post/example/obj")
    public String postDemoMethodObj(@RequestBody DemoObjParam demoObjParam) {
        String helloMessage = demoObjParam.getUserId() + " " + demoObjParam.getUserName() + ", Welcome to demoObjParam";
        return helloMessage;
    }

    /**
     * post:参数用List列表对象来接收
     *
     * @param objList
     * @return
     */
    @PostMapping("/post/example/obj/list")
    public String postDemoMethodObjList(@RequestBody List<DemoObjParam> objList) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        for (DemoObjParam demoObjParam : objList) {
            sb.append("(").append(demoObjParam.getUserId()).append(" ").append(demoObjParam.getUserName()).append(")").append(",");
        }
        sb.append("Welcome to obj list demo param");
        String helloMessage = sb.toString();
        return helloMessage;
    }

    /**
     * post:参数用Map来接收
     *
     * @param map
     * @return
     */
    @PostMapping("/post/example/obj/map")
    public String postDemoMethodObjMap(@RequestBody Map<String, Object> map) {
        String s = "";
        String userId = "";
        String userName = "";
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if ("userId".equals(key)) {
                userId = entry.getValue().toString();
            }
            if ("userName".equals(key)) {
                userName = entry.getValue().toString();
            }
        }
        s = "(" + userName + " " + userId + ")" + " Welcome to obj list demo param";
        return s;
    }

    /**
     * post:参数从header请求头中获取
     *
     * @param request
     * @param name
     * @return
     */
    @PostMapping("/post/example/header/param")
    public String postDemoMethodHeader(HttpServletRequest request, String name) {
        String uid = request.getHeader("uid");
        String s = "(" + name + " " + uid + ")" + ",Welcome to HttpServletRequest demo";
        System.out.println(request.toString());
        return s;
    }

    /**
     * 自定义starter测试方法
     *
     * @param request
     * @return
     */
    @PostMapping("/post/example/json/convert")
    public String postExampleJsonConvert(HttpServletRequest request) {
        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Person p = new Person();
        p.setName(name);
        p.setAge(age);
        return jsonConvertService.objectToJson(p);
    }

}
