package com.pingan.skycode.wagecalculate.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @ClassName: BasicInfo
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 18:52 2019/2/24
 * @Version: V1.0.0
 */
@ApiModel("薪资基本信息")
public class SalaryBasicInfoDTO {
    /**
     * 税前月薪
     */
    @NotNull(message = "税前月薪不可为空")
    @ApiModelProperty("税前月薪")
    private BigDecimal monSalaryBeforeTax;
    /**
     * 年终奖所得
     */
    @ApiModelProperty("年终奖所得")
    private BigDecimal yearEndAwards;
    /**
     * 社保汇缴基数
     */
    @NotNull(message = "社保汇缴基数不可为空")
    @ApiModelProperty("社保汇缴基数")
    private BigDecimal socialSecurityRemiBas;
    /**
     * 公积金汇缴基数
     */
    @NotNull(message = "公积金汇缴基数不可为空")
    @ApiModelProperty("公积金汇缴基数")
    private BigDecimal providentFundRemiBas;
    /**
     * 补充公积金汇缴基数
     */
    @NotNull(message = "补充公积金汇缴基数不可为空")
    @ApiModelProperty("补充公积金汇缴基数")
    private BigDecimal suppleprovidentFundRemiBas;
    /**
     * 补充公积金汇缴比例
     */
    @NotNull(message = "补充公积金汇缴比例不可为空")
    @ApiModelProperty("补充公积金汇缴比例")
    private Double suppleprovidentFundRemiRate;

    public BigDecimal getMonSalaryBeforeTax() {
        return monSalaryBeforeTax;
    }

    public void setMonSalaryBeforeTax(BigDecimal monSalaryBeforeTax) {
        this.monSalaryBeforeTax = monSalaryBeforeTax;
    }

    public BigDecimal getYearEndAwards() {
        return yearEndAwards;
    }

    public void setYearEndAwards(BigDecimal yearEndAwards) {
        this.yearEndAwards = yearEndAwards;
    }

    public BigDecimal getSocialSecurityRemiBas() {
        return socialSecurityRemiBas;
    }

    public void setSocialSecurityRemiBas(BigDecimal socialSecurityRemiBas) {
        this.socialSecurityRemiBas = socialSecurityRemiBas;
    }

    public BigDecimal getProvidentFundRemiBas() {
        return providentFundRemiBas;
    }

    public void setProvidentFundRemiBas(BigDecimal providentFundRemiBas) {
        this.providentFundRemiBas = providentFundRemiBas;
    }

    public BigDecimal getSuppleprovidentFundRemiBas() {
        return suppleprovidentFundRemiBas;
    }

    public void setSuppleprovidentFundRemiBas(BigDecimal suppleprovidentFundRemiBas) {
        this.suppleprovidentFundRemiBas = suppleprovidentFundRemiBas;
    }

    public Double getSuppleprovidentFundRemiRate() {
        return suppleprovidentFundRemiRate;
    }

    public void setSuppleprovidentFundRemiRate(Double suppleprovidentFundRemiRate) {
        this.suppleprovidentFundRemiRate = suppleprovidentFundRemiRate;
    }
}
