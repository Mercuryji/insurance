package com.pingan.skycode.basic;

import java.math.BigDecimal;

/**
 * @ClassName: Constant
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 19:34 2019/2/24
 * @Version: V1.0.0
 */
public class Constant {
    /**
     * 老个税起征点
     */
    public static final BigDecimal OLD_MARKING_POINT = new BigDecimal(3500);
    /**
     * 新个税起征点
     */
    public static final BigDecimal NEW_MARKING_POINT = new BigDecimal(5000);
    /**
     * 单位缴纳公积金比例
     */
    public static final Double FUND_RATE_COM = 0.07;
    /**
     * 个人缴纳公积金比例
     */
    public static final Double FUND_RATE_PER = 0.07;
    //public static final Double FUND_RATE_PER = 0.07;
    /**
     * 单位缴纳养老保险比例
     */
    public static final Double PENSION_RATE_COM = 0.22;
    /**
     * 个人缴纳养老保险比例
     */
    public static final Double PENSION_RATE_PER = 0.08;
    /**
     * 单位缴纳医疗保险比例
     */
    public static final Double MEDICAL_RATE_COM = 0.12;
    /**
     * 个人缴纳医疗保险比例
     */
    public static final Double MEDICAL_RATE_PER = 0.02;
    /**
     * 单位缴纳失业保险比例
     */
    public static final Double UNEMPL_RATE_COM = 0.017;
    /**
     * 个人缴纳失业保险比例
     */
    public static final Double UNEMPL_RATE_PER = 0.01;
    /**
     * 单位缴纳工伤保险比例
     */
    public static final Double INJURY_RATE_COM = 0.005;
    /**
     * 个人缴纳工伤保险比例
     */
    public static final Double INJURY_RATE_PER = 0.0;
    /**
     * 单位缴纳生育保险比例
     */
    public static final Double MATERNITY_RATE_COM = 0.008;
    /**
     * 个人缴纳生育保险比例
     */
    public static final Double MATERNITY_RATE_PER = 0.0;



    /**
     * 每个接受全日制教育子女专项扣除数
     */
    public static final BigDecimal CHILD_UNDER_EDU_DEDUCT = new BigDecimal(1000);
    /**
     * 赡养老人年满60岁总扣除数
     */
    public static final BigDecimal OLD_MAN_OVER_SIXTY_DEDUCT = new BigDecimal(2000);
    /**
     * 接受继续教育扣除数
     */
    public static final BigDecimal RECEIVE_CONTINUTE_DEDUCT = new BigDecimal(400);
    /**
     * 直辖市、省会城市租房扣除数
     */
    public static final BigDecimal MUNICIPALITY_CAPITAL_CITY_DEDUCT = new BigDecimal(1500);
    /**
     * 户籍人口大于等于100万城市租房扣除数
     */
    public static final BigDecimal GREATER_CITY_DEDUCT = new BigDecimal(1100);
    /**
     * 户籍人口小于100万城市租房扣除数
     */
    public static final BigDecimal SMALLER_CITY_DEDUCT = new BigDecimal(800);
    /**
     * 住房贷款扣除数
     */
    public static final BigDecimal HOUSE_LOAN_DEDUCT = new BigDecimal(1000);

}
