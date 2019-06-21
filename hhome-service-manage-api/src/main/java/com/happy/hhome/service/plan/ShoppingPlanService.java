package com.happy.hhome.service.plan;

import com.happy.hhome.bean.plan.ShoppingPlanDTO;
import com.happy.hhome.util.Result;

/**
 * @author haopeng17313
 */
public interface ShoppingPlanService {
    Result insertShoppingPlan(ShoppingPlanDTO shoppingPlanDTO);
    Result updateShoppingPlan(ShoppingPlanDTO shoppingPlanDTO);
    Result deleteShoppingPlan(ShoppingPlanDTO shoppingPlanDTO);
}
