package com.atguigu.gulimall.coupon.service;

import com.atguigu.gulimall.coupon.entity.HomeSubjectSpuEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;

import java.util.Map;

/**
 * 专题商品
 *
 * @author lzh
 * @email yydmw@yx.com
 * @date 2020-08-26 21:15:43
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

