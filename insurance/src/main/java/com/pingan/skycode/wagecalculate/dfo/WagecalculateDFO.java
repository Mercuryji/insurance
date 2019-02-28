package com.pingan.skycode.wagecalculate.dfo;

import java.math.BigDecimal;

/**
 * @ClassName: WagecalculateDFO
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 19:29 2019/2/24
 * @Version: V1.0.0
 */
public class WagecalculateDFO {
    private BigDecimal oldMonSalaryAfterTax;
    private BigDecimal newMonSalaryAfterTax;

    public BigDecimal getOldMonSalaryAfterTax() {
        return oldMonSalaryAfterTax;
    }

    public void setOldMonSalaryAfterTax(BigDecimal oldMonSalaryAfterTax) {
        this.oldMonSalaryAfterTax = oldMonSalaryAfterTax;
    }

    public BigDecimal getNewMonSalaryAfterTax() {
        return newMonSalaryAfterTax;
    }

    public void setNewMonSalaryAfterTax(BigDecimal newMonSalaryAfterTax) {
        this.newMonSalaryAfterTax = newMonSalaryAfterTax;
    }
}
