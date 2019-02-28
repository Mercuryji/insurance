package com.pingan.skycode.wagecalculate.controller;

import com.pingan.skycode.wagecalculate.dfo.WagecalculateDFO;
import com.pingan.skycode.wagecalculate.dto.RequestDTO;
import com.pingan.skycode.wagecalculate.dto.SalaryBasicInfoDTO;
import com.pingan.skycode.wagecalculate.dto.SpecialAddDeductionDTO;
import com.pingan.skycode.wagecalculate.service.WageCalculateService;
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
public class WageCalculateController {
    @Autowired
    WageCalculateService wageCalculateService;

    @ApiOperation("计算新老税法税后工资")
    @PostMapping("getMonSalaryAfterTax")
    public WagecalculateDFO getMonSalaryAfterTax(@RequestBody RequestDTO requestDTO){
        return wageCalculateService.calcaulate(requestDTO.getSalaryBasicInfoDTO(),requestDTO.getSpecialAddDeductionDTO());
    }

    @ApiOperation("计算新老税法税后工资")
    @PostMapping("testsss")
    public String testsss(@RequestParam String monSalaryBeforeTax, @RequestBody SpecialAddDeductionDTO specialAddDeductionDTO){
        return monSalaryBeforeTax + specialAddDeductionDTO.getWorkingCityCode();
    }
}
