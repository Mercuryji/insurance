package com.pingan.skycode.personcenter.service;

import com.pingan.skycode.personcenter.dfo.User;
import com.pingan.skycode.personcenter.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: TestService
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 21:17 2019/1/28
 * @Version: V1.0.0
 */
@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;
    public List<User> test(String passport){
        return testMapper.test(passport);
    }
}
