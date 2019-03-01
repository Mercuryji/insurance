package com.skycode.insurance.basic;

/**
 * @ClassName: Judge
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 10:43 2019/2/25
 * @Version: V1.0.0
 */
public enum Judge {
    /**
     * YES
     */
    YES("Y"),
    /**
     * NO
     */
    NO("N");

    private String status;

    Judge(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }

}
