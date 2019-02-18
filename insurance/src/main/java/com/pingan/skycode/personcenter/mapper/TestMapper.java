package com.pingan.skycode.personcenter.mapper;


import com.pingan.skycode.personcenter.dfo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<User> test(String passport);
}
