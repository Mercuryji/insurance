package com.skycode.insurance.wagecalculate.controller;

import com.skycode.insurance.wagecalculate.dfo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "测试方法")
    @GetMapping("/test")
    public String test(@ApiParam(value = "入参",required = true)@RequestParam String param){
        return param;
    }
    @ApiOperation(value = "测试mybatis")
    @GetMapping("/mybatistest")
    public List<User> mybatisTest(@ApiParam(value = "passport",required = true)@RequestParam String passport){
        return  null;
    }
}
