package com.manager;

import com.domain.DO.CouponDO;
import com.domain.DTO.CouponDTO;
import com.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:40 2017/12/11
 */
@Component
public class CouponManager {
    @Autowired
    CouponMapper couponMapper;

    public CouponDO selectCoupon(CouponDTO couponDTO) {
        return couponMapper.selectCoupon(couponDTO);
    }
}
