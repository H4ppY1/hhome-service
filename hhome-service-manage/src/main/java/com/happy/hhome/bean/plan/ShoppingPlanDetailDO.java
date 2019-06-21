package com.happy.hhome.bean.plan;

import java.math.BigDecimal;

/**
 * @author haopeng17313
 */
public class ShoppingPlanDetailDO {
    private Integer detailId;
    private Integer planId;
    private Integer settleDate;
    private BigDecimal targetAmount;
    private BigDecimal actualAmount;


    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Integer settleDate) {
        this.settleDate = settleDate;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }
}
