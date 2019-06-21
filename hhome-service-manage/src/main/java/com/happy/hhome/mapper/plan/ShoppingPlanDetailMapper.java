package com.happy.hhome.mapper.plan;

import com.happy.hhome.bean.plan.ShoppingPlanDetailDO;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface ShoppingPlanDetailMapper extends Mapper<ShoppingPlanDetailDO>, InsertListMapper<ShoppingPlanDetailDO> {
    /**
     * 设置实际完成金额
     * @param shoppingPlanDetailDO
     * @return
     */
    Integer setActualAmount(ShoppingPlanDetailDO shoppingPlanDetailDO);
}
