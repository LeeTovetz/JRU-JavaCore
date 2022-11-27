package com.javarush.task.jdk13.task28.task2806;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.FutureTask;

/* 
Параллельный парсинг
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lines.add(scanner.nextLine());
        }

        List<FutureTask<Link>> tasks = new ArrayList<>();
        for (String line : lines) {
            FutureTask<Link> task = new FutureTask<>(new ParseLinkTask(line));
            tasks.add(task);
            new Thread(task).start();
        }

        for (FutureTask<Link> task : tasks) {
            System.out.println(task.get());
        }
    }
}