package com.atguigu.common.servicebasehandler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Author: lzh
 * @Date: Create in 2020/7/6 21:29
 * @Description: 自动填充字段 实体类加注解 @TableField(fill = FieldFill.INSERT)
 * // 添加数据自动填充时间 @TableField(fill = FieldFill.INSERT_UPDATE) // 添加和修改都要
 * 本项目未使用
 */
@Repository
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
//        this.setFieldValByName("version", 1, metaObject); // 乐观锁版本 初始值1
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
