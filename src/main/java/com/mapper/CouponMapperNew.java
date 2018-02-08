package com.mapper;

import com.domain.DO.CampnouCouponDO;
import com.domain.DO.CouponDO;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.example.UpdateByExampleMapper;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午8:17 2018/2/8
 */
public interface CouponMapperNew extends Mapper<CampnouCouponDO>,BaseMapper<CampnouCouponDO>,UpdateByExampleMapper<CampnouCouponDO> {
}
