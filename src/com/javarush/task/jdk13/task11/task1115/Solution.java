package com.javarush.task.jdk13.task11.task1115;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Market market = new Market("Ашан");
        market.setProducts(List.of(
                new Product("Носки", 34),
                new Product("Зубная паста", 85),
                new Product("Сок", 19)));

        market.getProducts().stream()
                .map(Product::getName)
                .forEach(System.out::println);
    }
}
