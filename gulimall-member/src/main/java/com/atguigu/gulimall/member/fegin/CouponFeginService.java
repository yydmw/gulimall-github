package com.atguigu.gulimall.member.fegin;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author: lzh
 * @Date: Create in 2020/8/29 21:01
 * @Description:
 */
@FeignClient("gulimall-coupon")
public interface CouponFeginService {

    /**
     * 列表
     */
    @RequestMapping("/coupon/coupon/list")
    R list(@RequestParam Map<String, Object> params);

}
