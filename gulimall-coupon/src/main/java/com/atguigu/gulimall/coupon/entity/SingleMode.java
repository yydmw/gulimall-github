package com.atguigu.gulimall.coupon.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: lzh
 * @Date: Create in 2020/10/26 22:26
 * @Description: 单例模式
 */
public class SingleMode {
    private static boolean isExit = false;

    private static volatile SingleMode singleMode;

    private SingleMode() {
        synchronized (SingleMode.class) {
            if (isExit == false) {
                isExit = true;
            } else {
                throw new RuntimeException("不要试图用反射破坏异常");
            }
        }
    }

    private static SingleMode getInstance() {
        if (null == singleMode) {
            synchronized (SingleMode.class) {
                if (null == singleMode) {
                    singleMode = new SingleMode();
                }
            }
        }
        return singleMode;
    }

    public static void main(String[] args) throws Exception {
        Field isExit = SingleMode.class.getDeclaredField("isExit");
        isExit.setAccessible(true); // 取消私有
        Constructor<SingleMode> declaredConstructor = SingleMode.class.getDeclaredConstructor(null); // 用空构造获得对象
        declaredConstructor.setAccessible(true);
        SingleMode singleMode = declaredConstructor.newInstance();
        isExit.set(singleMode, false); // 给第一个对象的isExist变量设置成false
        SingleMode singleMode1 = declaredConstructor.newInstance();
        System.out.println(singleMode);
        System.out.println(singleMode1);
        /**
         * 单例模式中通过反射可以一直破坏单例模式
         * 可使用枚举阻止这一破坏
         **/
        // TODO 使用枚举优化单例模式
    }
}
