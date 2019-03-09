package com.skycode.insurance.wagecalculate.controller;

import com.skycode.insurance.wagecalculate.dfo.WagecalculateDFO;
import com.skycode.insurance.wagecalculate.dto.RequestDTO;
import com.skycode.insurance.wagecalculate.dto.SpecialAddDeductionDTO;
import com.skycode.insurance.wagecalculate.service.WageCalculateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: WageCalculateController
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 20:45 2019/2/25
 * @Version: V1.0.0
 */
@RestController
@RequestMapping("calculate")
@Api("工资计算器")
public class WageCalculateController {
    @Autowired
    WageCalculateService wageCalculateService;

    @ApiOperation("计算新老税法税后工资")
    @PostMapping("getMonSalaryAfterTax")
    public WagecalculateDFO getMonSalaryAfterTax(@ModelAttribute @RequestBody RequestDTO requestDTO){
        return wageCalculateService.calcaulate(requestDTO.getSalaryBasicInfoDTO(),requestDTO.getSpecialAddDeductionDTO());
    }

}
