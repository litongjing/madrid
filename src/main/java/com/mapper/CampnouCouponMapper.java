package com.mapper;

import com.domain.DO.CampnouCouponDO;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午7:35 2018/2/7
 */
public interface CampnouCouponMapper {
    int insertCampnouCoupon(CampnouCouponDO campnouCouponDO);

    CampnouCouponDO selectCampnouCoupon(Long id);
}
