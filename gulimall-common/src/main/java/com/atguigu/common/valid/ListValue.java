package com.atguigu.common.valid;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: lzh
 * @Date: Create in 2020/10/13 22:00
 * @Description:
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE }) // 该注解可以标记在哪个结构上面（方法，类，字段...）
@Retention(RUNTIME) // 运行时候启用
@Documented
@Constraint(validatedBy = { ListValueConstraintValidator.class }) // 指定校验器 类型是一个数组ConstraintValidator 可放多个
public @interface ListValue {

    String message() default "{com.atguigu.common.valid.ListValue.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int[] vals() default { }; // 校验内容

}
