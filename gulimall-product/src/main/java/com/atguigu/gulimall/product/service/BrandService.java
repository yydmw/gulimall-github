package com.atguigu.gulimall.product.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 品牌
 *
 * @author lzh
 * @email yydmw@yx.com
 * @date 2020-08-26 20:32:34
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);


    R updateDetail(BrandEntity brand);

}

