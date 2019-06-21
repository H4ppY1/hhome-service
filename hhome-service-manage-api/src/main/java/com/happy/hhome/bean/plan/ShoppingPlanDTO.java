package com.happy.hhome.bean.plan;

import lombok.Data;
import java.math.BigDecimal;

/**
 * @author haopeng17313
 */
@Data
public class ShoppingPlanDTO {
    private Integer planId;
    private Integer goodsId;
    private BigDecimal planAmount;
    private Integer beginDate;
    private Integer endDate;
    private String priority;
    private BigDecimal monthlyTargetAmount;
    private String planStatus;
    private Integer installmentsNum;
    private Integer riskRank;
    private Integer defaultCount;
    private Integer accountId;
}
