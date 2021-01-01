package com.atguigu.gulimall.coupon.service;

import com.atguigu.gulimall.coupon.entity.SeckillSkuNoticeEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author lzh
 * @email yydmw@yx.com
 * @date 2020-08-26 21:15:43
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

