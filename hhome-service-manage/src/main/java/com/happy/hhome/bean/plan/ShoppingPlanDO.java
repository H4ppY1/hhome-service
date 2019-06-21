package com.happy.hhome.bean.plan;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author haopeng17313
 */
@EqualsAndHashCode
@ToString
@Table(name="shoppingplan")
public class ShoppingPlanDO {
    @Id
    @Column(name = "plan_id")
    private Integer planId;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "plan_amount")
    private BigDecimal planAmount;

    @Column(name = "begin_date")
    private Integer beginDate;

    @Column(name = "end_date")
    private Integer endDate;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "monthly_target_amount")
    private BigDecimal monthlyTargetAmount;

    @Column(name = "plan_status")
    private String planStatus;

    @Column(name = "installments_num")
    private Integer installmentsNum;

    @Column(name = "risk_rank")
    private Integer riskRank;

    @Column(name = "default_count")
    private Integer defaultCount;

    @Column(name = "account_id")
    private Integer accountId;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(BigDecimal planAmount) {
        this.planAmount = planAmount;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getMonthlyTargetAmount() {
        return monthlyTargetAmount;
    }

    public void setMonthlyTargetAmount(BigDecimal monthlyTargetAmount) {
        this.monthlyTargetAmount = monthlyTargetAmount;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public Integer getInstallmentsNum() {
        return installmentsNum;
    }

    public void setInstallmentsNum(Integer installmentsNum) {
        this.installmentsNum = installmentsNum;
    }


    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getRiskRank() {
        return riskRank;
    }

    public void setRiskRank(Integer riskRank) {
        this.riskRank = riskRank;
    }

    public Integer getDefaultCount() {
        return defaultCount;
    }

    public void setDefaultCount(Integer defaultCount) {
        this.defaultCount = defaultCount;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
