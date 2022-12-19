package com.javarush.task.jdk13.task34.task3406;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/* 
Классные методы
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        print(getMethods(Set.of(Object.class, Math.class, Arrays.class)));
    }

    public static Map<Class<?>, Set<String>> getMethods(Set<Class<?>> classes) {
        Map<Class<?>, Set<String>> methodsMap = new HashMap<>();
        for (Class<?> clazz : classes) {
            Set<String> methodsSet = new HashSet<>();
            methodsMap.put(clazz, methodsSet);
            for (Method method : clazz.getDeclaredMethods()) {
                if (Modifier.isStatic(method.getModifiers())) {
                    methodsSet.add(method.getName());
                }
            }
        }

        return methodsMap;
    }

    public static void print(Map<?, ?> map) {
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
