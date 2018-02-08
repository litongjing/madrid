package com.manager;

import com.annotation.DataSource;
import com.domain.DO.CampnouCouponDO;
import com.domain.DO.CouponDO;
import com.domain.DTO.CouponDTO;
import com.mapper.CampnouCouponMapper;
import com.mapper.CouponMapper;
import com.mapper.CouponMapperNew;
import lombok.AllArgsConstructor;
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
    @Autowired
    CampnouCouponMapper campnouCouponMapper;
    @Autowired
    CouponMapperNew couponMapperNew;

    @DataSource("coupon")
    public CouponDO selectCoupon(CouponDTO couponDTO) {
        return couponMapper.selectCoupon(couponDTO);
    }

    @DataSource("campnou")
    public int insertCampnouCoupon(CampnouCouponDO campnouCouponDO) {
        return campnouCouponMapper.insertCampnouCoupon(campnouCouponDO);
    }

    @DataSource("campnou")
    public CampnouCouponDO selectCampnouCoupon(Long id) {
        return campnouCouponMapper.selectCampnouCoupon(id);
    }

    @DataSource("campnou")
    public CampnouCouponDO selectCampnouCouponNew(String id){
        CampnouCouponDO campnouCouponDO=new CampnouCouponDO();
        campnouCouponDO.setId(id);
        return couponMapperNew.selectOne(campnouCouponDO);
    }
}
