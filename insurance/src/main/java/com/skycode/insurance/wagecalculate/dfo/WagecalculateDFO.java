package com.skycode.insurance.wagecalculate.dfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @ClassName: WagecalculateDFO
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 19:29 2019/2/24
 * @Version: V1.0.0
 */
@ApiModel
public class WagecalculateDFO {
    /**
     * 老税法税后月薪
     */
    @ApiModelProperty("老税法税后月薪")
    private BigDecimal oldMonSalaryAfterTax;
    /**
     * 新税法税后月薪
     */
    @ApiModelProperty("新税法税后月薪")
    private BigDecimal newMonSalaryAfterTax;
    /**
     * 每月增加的收入
     */
    @ApiModelProperty("每月增加的收入")
    private BigDecimal increasedIncome;
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

    public BigDecimal getIncreasedIncome() {
        return increasedIncome;
    }

    public void setIncreasedIncome(BigDecimal increasedIncome) {
        this.increasedIncome = increasedIncome;
    }
}
