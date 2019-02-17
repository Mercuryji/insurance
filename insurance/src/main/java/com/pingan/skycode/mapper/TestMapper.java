package com.pingan.skycode.mapper;


import com.pingan.skycode.dfo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<User> test(String passport);
}
