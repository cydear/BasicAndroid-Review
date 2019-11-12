package com.basic.android.plugin;

import java.lang.reflect.Field;

public class FieldUtils {
    public static Object getField(Class clazz, Object target, String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getField(name);
        field.setAccessible(true);
        return field.get(target);
    }

    public static Field getField(Class clazz, String name) throws NoSuchFieldException {
        Field field = clazz.getField(name);
        field.setAccessible(true);
        return field;
    }

    public static void setField(Class clazz, Object target, String name, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getField(name);
        field.setAccessible(true);
        field.set(target, value);
    }
}
