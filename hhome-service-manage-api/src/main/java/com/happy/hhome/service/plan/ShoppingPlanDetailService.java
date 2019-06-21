package com.happy.hhome.service.plan;

import com.happy.hhome.bean.plan.ShoppingPlanDetailDTO;
import com.happy.hhome.util.Result;

/**
 * @author haopeng17313
 */
public interface ShoppingPlanDetailService {
    Result insertShoppingDetailPlan(ShoppingPlanDetailDTO shoppingPlanDetailDTO);
    Result updateShoppingDetailPlan(ShoppingPlanDetailDTO shoppingPlanDetailDTO);
    Result deleteShoppingDetailPlan(ShoppingPlanDetailDTO shoppingPlanDetailDTO);
    Result settleShoppingDetailPlan(ShoppingPlanDetailDTO shoppingPlanDetailDTO);
}
