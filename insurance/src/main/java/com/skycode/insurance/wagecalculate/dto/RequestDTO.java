package com.skycode.insurance.wagecalculate.dto;

import io.swagger.annotations.ApiModel;

/**
 * @ClassName: RequestDTO
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 9:23 2019/2/26
 * @Version: V1.0.0
 */
@ApiModel("输入参数")
public class RequestDTO {
    SalaryBasicInfoDTO salaryBasicInfoDTO;
    SpecialAddDeductionDTO specialAddDeductionDTO;

    public SalaryBasicInfoDTO getSalaryBasicInfoDTO() {
        return salaryBasicInfoDTO;
    }

    public void setSalaryBasicInfoDTO(SalaryBasicInfoDTO salaryBasicInfoDTO) {
        this.salaryBasicInfoDTO = salaryBasicInfoDTO;
    }

    public SpecialAddDeductionDTO getSpecialAddDeductionDTO() {
        return specialAddDeductionDTO;
    }

    public void setSpecialAddDeductionDTO(SpecialAddDeductionDTO specialAddDeductionDTO) {
        this.specialAddDeductionDTO = specialAddDeductionDTO;
    }
}
