package com.skycode.insurance.wagecalculate.service;

import com.skycode.insurance.basic.Constant;
import com.skycode.insurance.basic.Judge;
import com.skycode.insurance.basic.NewQuickDeduct;
import com.skycode.insurance.basic.OldQuickDeduct;
import com.skycode.insurance.wagecalculate.dfo.WagecalculateDFO;
import com.skycode.insurance.wagecalculate.dto.NewAndOldTaxPayableDTO;
import com.skycode.insurance.wagecalculate.dto.SalaryBasicInfoDTO;
import com.skycode.insurance.wagecalculate.dto.SpecialAddDeductionDTO;
import com.skycode.insurance.wagecalculate.mapper.WageCalculateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ClassName: WageCalculateService
 * @Description: TODO
 * @Author: jicaiyun
 * @Date: 19:30 2019/2/24
 * @Version: V1.0.0
 */
@Service
public class WageCalculateService {
    @Autowired
    WageCalculateMapper wageCalculateMapper;

    /**
     * 个人应缴纳的五险一金
     * @param salaryBasicInfoDTO
     * @return
     */
    public BigDecimal insurAndFundCalculate(BigDecimal monSalaryBeforeTax,SalaryBasicInfoDTO salaryBasicInfoDTO){
        //个人缴纳养老险
        BigDecimal pension = BigDecimal.valueOf(salaryBasicInfoDTO.getSocialSecurityRemiBas().intValue() * Constant.PENSION_RATE_PER);
        //个人缴纳医疗险
        BigDecimal medical = BigDecimal.valueOf(salaryBasicInfoDTO.getSocialSecurityRemiBas().intValue() * Constant.MEDICAL_RATE_PER);
        //个人缴纳工伤险
        BigDecimal injury= BigDecimal.valueOf(salaryBasicInfoDTO.getSocialSecurityRemiBas().intValue() * Constant.INJURY_RATE_PER);
        //个人缴纳失业险
        BigDecimal unemploy = BigDecimal.valueOf(salaryBasicInfoDTO.getSocialSecurityRemiBas().intValue() * Constant.UNEMPL_RATE_PER);
        //个人缴纳生育险
        BigDecimal maternity = BigDecimal.valueOf(salaryBasicInfoDTO.getSocialSecurityRemiBas().intValue() * Constant.MATERNITY_RATE_PER);
        //个人缴纳公积金
        BigDecimal houseFund =  BigDecimal.valueOf((int)salaryBasicInfoDTO.getProvidentFundRemiBas().intValue() * Constant.FUND_RATE_PER);
        //个人缴纳补充公积金
        BigDecimal suppleHouseFund = BigDecimal.valueOf(salaryBasicInfoDTO.getSuppleprovidentFundRemiBas().intValue() * salaryBasicInfoDTO.getSuppleprovidentFundRemiRate());
        //个人需缴纳的五险一金
        BigDecimal insuranceAndFund = pension.add(medical).add(injury).add(unemploy).add(maternity).add(houseFund).add(suppleHouseFund);
        return insuranceAndFund;
    }

    /**
     * 每月可扣除的专项扣除数总和
     * @param specialAddDeductionDTO
     * @return
     */
    public BigDecimal specTaxDeductCalculate(SpecialAddDeductionDTO specialAddDeductionDTO){
        //个税专项总扣除数
        BigDecimal specialTaxDeduct = new BigDecimal(0);
        //接受全日制教育子女扣除数
        BigDecimal childUnderEduDeduct = new BigDecimal(0);
        //赡养老人年满60岁扣除数
        BigDecimal oldManOverSixtyDeduct = new BigDecimal(0);
        //接受继续教育扣除数
        BigDecimal receiveContinuteEduDeduct = new BigDecimal(0);
        //租房扣除数
        BigDecimal rentHouseDeduct = new BigDecimal(0);
        //住房贷款扣除数
        BigDecimal houseLoanDeduct = new BigDecimal(0);

        if(specialAddDeductionDTO.getChildUnderEduCount().intValue() <= 2){
            childUnderEduDeduct = specialAddDeductionDTO.getChildUnderEduCount().multiply(Constant.CHILD_UNDER_EDU_DEDUCT);
        }else{
            childUnderEduDeduct = Constant.CHILD_UNDER_EDU_DEDUCT.multiply(new BigDecimal(2));
        }

        if(specialAddDeductionDTO.getHasOverSixtyMan().equals(Judge.YES.getStatus())){
            oldManOverSixtyDeduct = Constant.OLD_MAN_OVER_SIXTY_DEDUCT.divide(new BigDecimal(specialAddDeductionDTO.getChildCountOfOldMan()));
        }

        if(specialAddDeductionDTO.getIsReceContinueEdu().equals(Judge.YES.getStatus())){
            receiveContinuteEduDeduct = Constant.RECEIVE_CONTINUTE_DEDUCT;
        }

        if(specialAddDeductionDTO.getNotHasHouse().equals(Judge.YES.getStatus())){
            String isCapitalCity = wageCalculateMapper.isCapitalCity(specialAddDeductionDTO.getWorkingCityCode());
            String isManicipality = wageCalculateMapper.isManicipality(specialAddDeductionDTO.getWorkingCityCode());
            String isGreaterCity = wageCalculateMapper.isGreaterCity(specialAddDeductionDTO.getWorkingCityCode());
            if(isCapitalCity.equals(Judge.YES.getStatus()) || isManicipality.equals(Judge.YES.getStatus())){
                rentHouseDeduct = Constant.MUNICIPALITY_CAPITAL_CITY_DEDUCT;
            }else{
                if(isGreaterCity.equals(Judge.YES.getStatus())){
                    rentHouseDeduct = Constant.GREATER_CITY_DEDUCT;
                }else if(isGreaterCity.equals(Judge.NO.getStatus())){
                    rentHouseDeduct = Constant.SMALLER_CITY_DEDUCT;
                }
            }
        }

        if(specialAddDeductionDTO.getHasHouseLoan().equals(Judge.YES.getStatus())){
            houseLoanDeduct = Constant.HOUSE_LOAN_DEDUCT;
        }
        specialTaxDeduct = childUnderEduDeduct.add(oldManOverSixtyDeduct).add(receiveContinuteEduDeduct)
                .add(rentHouseDeduct).add(houseLoanDeduct);
        return specialTaxDeduct;
    }

    /**
     * 新老税法每月应纳税额计算
     * @param salaryBasicInfoDTO
     * @param insuranceAndFund
     * @param specialTaxDeduct
     * @return
     */
    public NewAndOldTaxPayableDTO taxPayable(SalaryBasicInfoDTO salaryBasicInfoDTO, BigDecimal insuranceAndFund, BigDecimal specialTaxDeduct){
        NewAndOldTaxPayableDTO newAndOldTaxPayableDTO = new NewAndOldTaxPayableDTO();
        //老税法每月应纳税所得额
        BigDecimal oldTaxableIncome = salaryBasicInfoDTO.getMonSalaryBeforeTax().subtract(Constant.OLD_MARKING_POINT).subtract(insuranceAndFund);
        //新税法每月应纳所得额
        BigDecimal newTaxableIncome = salaryBasicInfoDTO.getMonSalaryBeforeTax().subtract(Constant.NEW_MARKING_POINT).subtract(insuranceAndFund).subtract(specialTaxDeduct);
        //老税法每月应纳税
        BigDecimal oldTaxPayable;
        //新税法每月应纳税
        BigDecimal newTaxPayable;
        //新税法税率
        Double newQuickRate = 0.0;
        //新税法速算扣除数
        BigDecimal newQuickAmount = new BigDecimal(0);
        //老税法税率
        Double oldQuickRate = 0.0;
        //老税法速算扣除数
        BigDecimal oldQuickAmount = new BigDecimal(0);

        //新税法速算扣除数和扣税比率计算
        if(newTaxableIncome.intValue() <= 3000){
            newQuickRate = NewQuickDeduct.LEVEL1.getRate();
            newQuickAmount = NewQuickDeduct.LEVEL1.getAmount();

        }
        if(3000 < newTaxableIncome.intValue() && newTaxableIncome.intValue() <= 12000){
            newQuickRate = NewQuickDeduct.LEVEL2.getRate();
            newQuickAmount = NewQuickDeduct.LEVEL2.getAmount();
        }
        if(12000 < newTaxableIncome.intValue() && newTaxableIncome.intValue() <= 25000){
            newQuickRate = NewQuickDeduct.LEVEL3.getRate();
            newQuickAmount = NewQuickDeduct.LEVEL3.getAmount();
        }
        if(25000 < newTaxableIncome.intValue() && newTaxableIncome.intValue() <= 35000){
            newQuickRate = NewQuickDeduct.LEVEL4.getRate();
            newQuickAmount = NewQuickDeduct.LEVEL4.getAmount();
        }
        if(35000 < newTaxableIncome.intValue() && newTaxableIncome.intValue() <= 55000){
            newQuickRate = NewQuickDeduct.LEVEL5.getRate();
            newQuickAmount = NewQuickDeduct.LEVEL5.getAmount();
        }
        if(55000 < newTaxableIncome.intValue() && newTaxableIncome.intValue() <= 80000){
            newQuickRate = NewQuickDeduct.LEVEL6.getRate();
            newQuickAmount = NewQuickDeduct.LEVEL6.getAmount();
        }
        if(newTaxableIncome.intValue() > 80000){
            newQuickRate = NewQuickDeduct.LEVEL7.getRate();
            newQuickAmount = NewQuickDeduct.LEVEL7.getAmount();
        }
        newTaxPayable = new BigDecimal(newTaxableIncome.intValue() * newQuickRate - newQuickAmount.intValue());
        if(newTaxPayable.intValue() < 0){
            newTaxPayable = BigDecimal.valueOf(0);
        }
        //老税法速算扣除数和扣税比率计算
        if(oldTaxableIncome.intValue() <= 1500){
            oldQuickRate = OldQuickDeduct.LEVEL1.getRate();
            oldQuickAmount = OldQuickDeduct.LEVEL1.getAmount();

        }
        if(1500 < oldTaxableIncome.intValue() && oldTaxableIncome.intValue() <= 4500){
            oldQuickRate = OldQuickDeduct.LEVEL2.getRate();
            oldQuickAmount = OldQuickDeduct.LEVEL2.getAmount();
        }
        if(4500 < oldTaxableIncome.intValue() && oldTaxableIncome.intValue() <= 9000){
            oldQuickRate = OldQuickDeduct.LEVEL3.getRate();
            oldQuickAmount = OldQuickDeduct.LEVEL3.getAmount();
        }
        if(9000 < oldTaxableIncome.intValue() && oldTaxableIncome.intValue() <= 35000){
            oldQuickRate = OldQuickDeduct.LEVEL4.getRate();
            oldQuickAmount = OldQuickDeduct.LEVEL4.getAmount();
        }
        if(35000 < oldTaxableIncome.intValue() && oldTaxableIncome.intValue() <= 55000){
            oldQuickRate = OldQuickDeduct.LEVEL5.getRate();
            oldQuickAmount = OldQuickDeduct.LEVEL5.getAmount();
        }
        if(55000 < oldTaxableIncome.intValue() && oldTaxableIncome.intValue() <= 80000){
            oldQuickRate = OldQuickDeduct.LEVEL6.getRate();
            oldQuickAmount = OldQuickDeduct.LEVEL6.getAmount();
        }
        if(oldTaxableIncome.intValue() > 80000){
            oldQuickRate = OldQuickDeduct.LEVEL7.getRate();
            oldQuickAmount = OldQuickDeduct.LEVEL7.getAmount();
        }
        oldTaxPayable = new BigDecimal(oldTaxableIncome.intValue() * oldQuickRate - oldQuickAmount.intValue());
        if(oldTaxPayable.intValue() < 0){
            oldTaxPayable = BigDecimal.valueOf(0);
        }
        newAndOldTaxPayableDTO.setOldTaxPayable(oldTaxPayable);
        newAndOldTaxPayableDTO.setNewTaxPayable(newTaxPayable);
        return newAndOldTaxPayableDTO;
    }
    public WagecalculateDFO calcaulate(SalaryBasicInfoDTO salaryBasicInfoDTO, SpecialAddDeductionDTO specialAddDeductionDTO){
        WagecalculateDFO wagecalculateDFO = new WagecalculateDFO();
        //每月税前工资
        BigDecimal monSalaryBeforeTax = salaryBasicInfoDTO.getMonSalaryBeforeTax();
        //每月应缴纳五险一金
        BigDecimal insuranceAndFund = insurAndFundCalculate(monSalaryBeforeTax,salaryBasicInfoDTO);
        BigDecimal specialTaxDeduct = specTaxDeductCalculate(specialAddDeductionDTO);
        //老税法应缴纳税额
        BigDecimal oldTaxPayable = taxPayable(salaryBasicInfoDTO,insuranceAndFund,specialTaxDeduct).getOldTaxPayable();
        //新税法应缴纳税额
        BigDecimal newTaxPayable = taxPayable(salaryBasicInfoDTO,insuranceAndFund,specialTaxDeduct).getNewTaxPayable();
        //老税法税后工资
        BigDecimal oldMonSalaryAfterTax = monSalaryBeforeTax.subtract(insuranceAndFund).subtract(oldTaxPayable);
        //新税法税后工资
        BigDecimal newMonSalaryAfterTax = monSalaryBeforeTax.subtract(insuranceAndFund).subtract(newTaxPayable);
        wagecalculateDFO.setOldMonSalaryAfterTax(oldMonSalaryAfterTax);
        wagecalculateDFO.setNewMonSalaryAfterTax(newMonSalaryAfterTax);
        return wagecalculateDFO;
    }
}
