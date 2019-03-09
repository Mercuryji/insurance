package com.skycode.insurance.wagecalculate.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @ClassName: SpecialAddDeductionDTO
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 20:20 2019/2/24
 * @Version: V1.0.0
 */
@ApiModel("个税专项扣除")
public class SpecialAddDeductionDTO {
    /**
     * 接受全日制教育的子女个数
     */
    @ApiModelProperty("接受全日制教育的子女个数")
    private BigDecimal ChildUnderEduCount;
    /**
     *是否有年满60岁的老人
     */
    @ApiModelProperty("是否有年满60岁的老人")
    private String hasOverSixtyMan;
    /**
     *年满60岁老人的子女个数
     */
    @ApiModelProperty("年满60岁老人的子女个数")
    private BigDecimal childCountOfOldMan;
    /**
     * 是否在国内接受学历学位继续教育
     */
    @ApiModelProperty("是否在国内接受学历学位继续教育")
    private String isReceContinueEdu;
    /**
     * 本人和配偶在工作城市是否均无房
     */
    @ApiModelProperty("本人和配偶在工作城市是否均无房")
    private String notHasHouse;
    /**
     * 工作城市
     */
    @ApiModelProperty("工作城市")
    private String WorkingCityCode;
    /**
     * 本人或配偶是否有住房贷款
     */
    @ApiModelProperty("本人或配偶是否有住房贷款")
    private String hasHouseLoan;

    public BigDecimal getChildUnderEduCount() {
        return ChildUnderEduCount;
    }

    public void setChildUnderEduCount(BigDecimal childUnderEduCount) {
        ChildUnderEduCount = childUnderEduCount;
    }

    public String getHasOverSixtyMan() {
        return hasOverSixtyMan;
    }

    public void setHasOverSixtyMan(String hasOverSixtyMan) {
        this.hasOverSixtyMan = hasOverSixtyMan;
    }

    public BigDecimal getChildCountOfOldMan() {
        return childCountOfOldMan;
    }

    public void setChildCountOfOldMan(BigDecimal childCountOfOldMan) {
        this.childCountOfOldMan = childCountOfOldMan;
    }

    public String getIsReceContinueEdu() {
        return isReceContinueEdu;
    }

    public void setIsReceContinueEdu(String isReceContinueEdu) {
        this.isReceContinueEdu = isReceContinueEdu;
    }

    public String getNotHasHouse() {
        return notHasHouse;
    }

    public void setNotHasHouse(String notHasHouse) {
        this.notHasHouse = notHasHouse;
    }

    public String getWorkingCityCode() {
        return WorkingCityCode;
    }

    public void setWorkingCityCode(String workingCityCode) {
        WorkingCityCode = workingCityCode;
    }

    public String getHasHouseLoan() {
        return hasHouseLoan;
    }

    public void setHasHouseLoan(String hasHouseLoan) {
        this.hasHouseLoan = hasHouseLoan;
    }
}
