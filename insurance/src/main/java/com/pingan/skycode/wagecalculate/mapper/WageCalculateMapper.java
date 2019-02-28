package com.pingan.skycode.wagecalculate.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WageCalculateMapper {
    /**
     * 判断是否是省会城市
     * @param cityCode
     * @return
     */
    String isCapitalCity(String cityCode);

    /**
     * 判断是否是直辖市
     * @param cityCode
     * @return
     */
    String isManicipality(String cityCode);

    String isGreaterCity(String cityCode);
}
