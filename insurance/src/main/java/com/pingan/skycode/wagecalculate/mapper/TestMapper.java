package com.pingan.skycode.wagecalculate.mapper;


import com.pingan.skycode.wagecalculate.dfo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<User> test(String passport);
}
