package com.skycode.insurance.basic;

import java.math.BigDecimal;

/**
 * @ClassName: NewQuickDeduct
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 11:19 2019/2/25
 * @Version: V1.0.0
 */
public enum NewQuickDeduct {
    /**
     *每月应纳税所得额<=3000
     */
    LEVEL1(0.03,new BigDecimal(0)),
    /**
     * 3000<每月应纳税所得额<=12000
     */
    LEVEL2(0.1 ,new BigDecimal(210)),
    /**
     * 12000<每月应纳税所得额<=25000
     */
    LEVEL3(0.2 ,new BigDecimal(1410)),
    /**
     * 25000<每月应纳税所得额<=35000
     */
    LEVEL4(0.25,new BigDecimal(2660)),
    /**
     *35000<每月应纳税所得额<=55000
     */
    LEVEL5(0.3 ,new BigDecimal(4410)),
    /**
     * 55000<每月应纳税所得额<=80000
     */
    LEVEL6(0.35,new BigDecimal(7160)),
    /**
     * 每月应纳税所得额>80000
     */
    LEVEL7(0.45,new BigDecimal(15160));

    private Double rate;
    private BigDecimal amount;
    NewQuickDeduct(Double rate, BigDecimal amount){
        this.rate = rate;
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}