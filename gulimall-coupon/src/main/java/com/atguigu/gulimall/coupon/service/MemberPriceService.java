package com.atguigu.gulimall.coupon.service;

import com.atguigu.gulimall.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author lzh
 * @email yydmw@yx.com
 * @date 2020-08-26 21:15:43
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

