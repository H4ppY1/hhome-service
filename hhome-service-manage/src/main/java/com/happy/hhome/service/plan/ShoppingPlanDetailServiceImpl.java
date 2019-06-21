package com.happy.hhome.service.plan;

import com.happy.hhome.bean.plan.ShoppingPlanDO;
import com.happy.hhome.bean.plan.ShoppingPlanDetailDO;
import com.happy.hhome.bean.plan.ShoppingPlanDetailDTO;
import com.happy.hhome.constants.Constants;
import com.happy.hhome.converter.plan.ShoppingPlanDetailConverter;
import com.happy.hhome.mapper.plan.ShoppingPlanDetailMapper;
import com.happy.hhome.mapper.plan.ShoppingPlanMapper;
import com.happy.hhome.service.BaseService;
import com.happy.hhome.util.Result;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author haopeng17313
 */
public class ShoppingPlanDetailServiceImpl extends BaseService implements ShoppingPlanDetailService {

    @Resource
    private ShoppingPlanMapper shoppingPlanMapper;
    @Resource
    private ShoppingPlanDetailMapper shoppingPlanDetailMapper;
    @Resource
    private ShoppingPlanDetailConverter shoppingPlanDetailConverter;

    @Override
    public Result insertShoppingDetailPlan(ShoppingPlanDetailDTO shoppingPlanDetailDTO) {
        shoppingPlanDetailMapper.insert(shoppingPlanDetailConverter.toDO(shoppingPlanDetailDTO));
        return success();
    }

    @Override
    public Result updateShoppingDetailPlan(ShoppingPlanDetailDTO shoppingPlanDetailDTO) {
        shoppingPlanDetailMapper.updateByPrimaryKeySelective(shoppingPlanDetailConverter.toDO(shoppingPlanDetailDTO));
        return success();
    }

    @Override
    public Result deleteShoppingDetailPlan(ShoppingPlanDetailDTO shoppingPlanDetailDTO) {
        shoppingPlanDetailMapper.deleteByPrimaryKey(shoppingPlanDetailConverter.toDO(shoppingPlanDetailDTO));
        return success();
    }

    @Override
    public Result settleShoppingDetailPlan(ShoppingPlanDetailDTO shoppingPlanDetailDTO) {
        final BigDecimal targetAmount = shoppingPlanDetailDTO.getTargetAmount();
        final BigDecimal actualAmount = shoppingPlanDetailDTO.getActualAmount();
        if (targetAmount.compareTo(actualAmount) > Constants.ZERO_NUM) {

        } else {
            shoppingPlanMapper.defaultRecord(shoppingPlanDetailDTO.getPlanId());
        }
        ShoppingPlanDetailDO shoppingPlanDetail = shoppingPlanDetailConverter.toDO(shoppingPlanDetailDTO);
        shoppingPlanDetailMapper.setActualAmount(shoppingPlanDetail);
        return success();
    }

}
