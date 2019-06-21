package com.happy.hhome.service.plan;

import com.happy.hhome.bean.plan.ShoppingPlanDTO;
import com.happy.hhome.converter.plan.ShoppingPlanConverter;
import com.happy.hhome.mapper.plan.ShoppingPlanMapper;
import com.happy.hhome.service.BaseService;
import com.happy.hhome.util.Result;

import javax.annotation.Resource;

/**
 * @author haopeng17313
 */
public class ShoppingPlanServiceImpl extends BaseService implements ShoppingPlanService {

    @Resource
    private ShoppingPlanMapper shoppingPlanMapper;
    @Resource
    private ShoppingPlanConverter shoppingPlanConverter;

    @Override
    public Result insertShoppingPlan(ShoppingPlanDTO shoppingPlanDTO) {
        shoppingPlanMapper.insert(shoppingPlanConverter.toDO(shoppingPlanDTO));
        return success();
    }

    @Override
    public Result updateShoppingPlan(ShoppingPlanDTO shoppingPlanDTO) {
        shoppingPlanMapper.updateByPrimaryKeySelective(shoppingPlanConverter.toDO(shoppingPlanDTO));
        return success();
    }

    @Override
    public Result deleteShoppingPlan(ShoppingPlanDTO shoppingPlanDTO) {
        shoppingPlanMapper.deleteByPrimaryKey(shoppingPlanConverter.toDO(shoppingPlanDTO));
        return success();
    }
}
