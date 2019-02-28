package com.pingan.skycode.wagecalculate.dto;

import java.math.BigDecimal;

/**
 * @ClassName: NewAndOldTaxPayableDTO
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 20:11 2019/2/25
 * @Version: V1.0.0
 */
public class NewAndOldTaxPayableDTO {
    private BigDecimal oldTaxPayable;
    private BigDecimal newTaxPayable;

    public BigDecimal getOldTaxPayable() {
        return oldTaxPayable;
    }

    public void setOldTaxPayable(BigDecimal oldTaxPayable) {
        this.oldTaxPayable = oldTaxPayable;
    }

    public BigDecimal getNewTaxPayable() {
        return newTaxPayable;
    }

    public void setNewTaxPayable(BigDecimal newTaxPayable) {
        this.newTaxPayable = newTaxPayable;
    }
}
