package com.happy.hhome.mapper.plan;

import com.happy.hhome.bean.plan.ShoppingPlanDO;
import tk.mybatis.mapper.common.Mapper;

public interface ShoppingPlanMapper extends Mapper<ShoppingPlanDO> {
    Integer defaultRecord(Integer planId);
}
