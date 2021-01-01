package com.atguigu.gulimall.coupon.service;

import com.atguigu.gulimall.coupon.entity.HomeSubjectEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;

import java.util.Map;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author lzh
 * @email yydmw@yx.com
 * @date 2020-08-26 21:15:43
 */
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    public static void main(String[] args) {
        System.out.println((int)' ');
        String ss = ("_"+(char) 0+"_");
        String s = ss.replaceAll(" ", "");
        System.out.println("s"+s);
        String s1 = ss.replaceAll((char) 0 + "", "");
        System.out.println("s1:"+s1);
        System.out.println("_"+(char) 0+"_");

    }
}

