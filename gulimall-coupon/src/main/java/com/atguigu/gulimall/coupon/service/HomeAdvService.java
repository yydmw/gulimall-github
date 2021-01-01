package com.atguigu.gulimall.coupon.service;

import com.atguigu.gulimall.coupon.entity.HomeAdvEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;

import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author lzh
 * @email yydmw@yx.com
 * @date 2020-08-26 21:15:43
 */
public interface HomeAdvService extends IService<HomeAdvEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

