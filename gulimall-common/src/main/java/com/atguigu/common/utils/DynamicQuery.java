package com.atguigu.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.experimental.Accessors;

/**
 * @Author: lzh
 * @Date: Create in 2020/10/17 16:10
 * @Description: 动态查询 添加大小写转换
 */
@Accessors(chain = true)
public class DynamicQuery<T> extends QueryWrapper<T> {

    @Override
    protected String columnToString(String column) {
        return StringUtils.camelToUnderline(column);
    }
}