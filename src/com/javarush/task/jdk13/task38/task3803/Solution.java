package com.javarush.task.jdk13.task38.task3803;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static <T> boolean printFullyQualifiedNames(Class<T> c) {
        PrepareMyTest prepareMyTest = c.getDeclaredAnnotation(PrepareMyTest.class);
        if (prepareMyTest == null) {
            return false;
        }
        for (String fullyQualifiedName : prepareMyTest.fullyQualifiedNames()) {
            System.out.println(fullyQualifiedName);
        }
        return true;
    }

    public static <T> boolean printValues(Class<T> c) {
        PrepareMyTest prepareMyTest = c.getDeclaredAnnotation(PrepareMyTest.class);
        if (prepareMyTest == null) {
            return false;
        }
        for (Class<?> clazz : prepareMyTest.value()) {
            System.out.println(clazz.getSimpleName());
        }
        return true;
    }
}
