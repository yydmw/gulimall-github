package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author lzh
 * @email yydmw@yx.com
 * @date 2020-08-26 21:15:43
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
