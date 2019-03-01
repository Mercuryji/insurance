package com.skycode.insurance.basic;

import java.math.BigDecimal;

/**
 * @ClassName: OldQuickDeduct
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 19:35 2019/2/25
 * @Version: V1.0.0
 */
public enum OldQuickDeduct {
    /**
     *每月应纳税所得额<=3000
     */
    LEVEL1(0.03,new BigDecimal(0)),
    /**
     * 3000<每月应纳税所得额<=12000
     */
    LEVEL2(0.1 ,new BigDecimal(105)),
    /**
     * 12000<每月应纳税所得额<=25000
     */
    LEVEL3(0.2 ,new BigDecimal(555)),
    /**
     * 25000<每月应纳税所得额<=35000
     */
    LEVEL4(0.25,new BigDecimal(1005)),
    /**
     *35000<每月应纳税所得额<=55000
     */
    LEVEL5(0.3 ,new BigDecimal(2755)),
    /**
     * 55000<每月应纳税所得额<=80000
     */
    LEVEL6(0.35,new BigDecimal(5505)),
    /**
     * 每月应纳税所得额>80000
     */
    LEVEL7(0.45,new BigDecimal(13505));

    private Double rate;
    private BigDecimal amount;
    OldQuickDeduct(Double rate, BigDecimal amount){
        this.rate = rate;
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
