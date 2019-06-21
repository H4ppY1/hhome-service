package com.happy.hhome.bean.plan;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author haopeng17313
 */
@Data
public class ShoppingPlanDetailDTO {
    private Integer detailId;
    private Integer planId;
    private Integer settleDate;
    private BigDecimal targetAmount;
    private BigDecimal actualAmount;
}
