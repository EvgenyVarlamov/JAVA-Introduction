package ru.geekbrains;

import java.util.ArrayList;
import java.util.Arrays;

public class Task1 {
    //1. Пусть дан произвольный список целых чисел, удалить из него четные числа

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, -34, 5, 0, 48, 275, -17, 64, 77));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
}
