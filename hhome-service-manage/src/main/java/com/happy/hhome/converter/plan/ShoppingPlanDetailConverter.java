package com.happy.hhome.converter.plan;

import com.happy.hhome.bean.plan.ShoppingPlanDetailDO;
import com.happy.hhome.bean.plan.ShoppingPlanDetailDTO;
import com.happy.hhome.converter.BaseDoDtoConverter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingPlanDetailConverter extends BaseDoDtoConverter<ShoppingPlanDetailDO, ShoppingPlanDetailDTO> {
}
