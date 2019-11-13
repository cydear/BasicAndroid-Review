package com.basic.android.reflect;

import com.basic.android.http.IpService;

import java.lang.reflect.Method;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-11-13 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class ReflectMian {
    public static void main(String[] args) {
        //Test getGenericReturnType
        testGetGenericReturnType();
    }

    private static void testGetGenericReturnType() {
        try {
            Class clazz = Class.forName("com.basic.android.http.IpService");
            Method method = clazz.getDeclaredMethod("getIpMsg", String.class);
            System.out.println("getGenericReturnType:" + method.getGenericReturnType());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
