package com.mapper;

import com.domain.DO.CouponDO;
import com.domain.DTO.CouponDTO;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午11:17 2017/12/11
 */
public interface CouponMapper {
    CouponDO selectCoupon(CouponDTO couponDTO);
}
