package com.happy.hhome.converter.plan;

import com.happy.hhome.bean.plan.ShoppingPlanDO;
import com.happy.hhome.bean.plan.ShoppingPlanDTO;
import com.happy.hhome.converter.BaseDoDtoConverter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingPlanConverter extends BaseDoDtoConverter<ShoppingPlanDO, ShoppingPlanDTO> {
}
