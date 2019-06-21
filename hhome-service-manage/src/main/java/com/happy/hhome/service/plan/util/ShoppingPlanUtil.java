package com.happy.hhome.service.plan.util;

import com.happy.hhome.bean.plan.ShoppingPlanDO;
import com.happy.hhome.bean.plan.ShoppingPlanDetailDO;
import com.happy.hhome.bean.plan.ShoppingPlanDetailDTO;
import com.happy.hhome.constants.Constants;
import com.happy.hhome.constants.PlanConstants;
import com.happy.hhome.mapper.plan.ShoppingPlanDetailMapper;
import com.happy.hhome.mapper.plan.ShoppingPlanMapper;
import com.happy.hhome.util.DateExUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haopeng17313
 */
public class ShoppingPlanUtil {
    @Resource
    private ShoppingPlanMapper shoppingPlanMapper;
    @Resource
    private ShoppingPlanDetailMapper shoppingPlanDetailMapper;
    @Resource
    private DateExUtils dateExUtils;

    public void generateShoppingPlanDetail(Integer planId) {
        ShoppingPlanDO shoppingPlanDO = new ShoppingPlanDO();
        shoppingPlanDO.setPlanId(planId);
        ShoppingPlanDO shoppingPlan = shoppingPlanMapper.selectByPrimaryKey(shoppingPlanDO);
        final Integer beginDate = shoppingPlan.getBeginDate();
        final Integer endDate = shoppingPlan.getEndDate();
        final BigDecimal monthlyTargetAmount = shoppingPlan.getMonthlyTargetAmount();
        String settleDateStr = beginDate.toString().substring(0, 6) + PlanConstants.PLAN_SETTLE_DAY;
        Integer settleDate = Integer.valueOf(settleDateStr);
        if (beginDate > settleDate) {
            settleDate = dateExUtils.addMonths(settleDate, Constants.ONE_NUM);
        }
        List<ShoppingPlanDetailDO> shoppingPlanDetailDOList = new ArrayList<>();
        do {
            ShoppingPlanDetailDO shoppingPlanDetailDO = new ShoppingPlanDetailDO();
            shoppingPlanDetailDO.setPlanId(planId);
            shoppingPlanDetailDO.setSettleDate(settleDate);
            shoppingPlanDetailDO.setTargetAmount(monthlyTargetAmount);
            shoppingPlanDetailDO.setActualAmount(BigDecimal.ZERO);
            shoppingPlanDetailDOList.add(shoppingPlanDetailDO);
            settleDate = dateExUtils.addMonths(settleDate, Constants.ONE_NUM);
            if (settleDate > endDate) {
                settleDate = endDate;
            }
        } while (settleDate < endDate);
        shoppingPlanDetailMapper.insertList(shoppingPlanDetailDOList);
    }
}
