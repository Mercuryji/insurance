package com.pingan.skycode.wagecalculate.controller;

import com.pingan.skycode.wagecalculate.dfo.User;
import com.pingan.skycode.wagecalculate.service.TestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 21:35 2019/1/24
 * @Version: V1.0.0
 */
@RestController
@RequestMapping("/index")
public class TestController {
    @Autowired
    private TestService testService;
    @ApiOperation(value = "测试方法")
    @GetMapping("/test")
    public String test(@ApiParam(value = "入参",required = true)@RequestParam String param){
        return param;
    }
    @ApiOperation(value = "测试mybatis")
    @GetMapping("/mybatistest")
    public List<User> mybatisTest(@ApiParam(value = "passport",required = true)@RequestParam String passport){
        return testService.test(passport);
    }
}
