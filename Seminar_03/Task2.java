package ru.geekbrains;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    //2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(fillList(list));
        System.out.print("Максимальное значение списка: ");
        System.out.println(maxValue(list));
        System.out.print("Минимальное значение списка: ");
        System.out.println(minValue(list));
        System.out.print("Среднее арифметическое списка: ");
        System.out.println(averageValue(list));
    }

    public static ArrayList<Integer> fillList(ArrayList<Integer> arr) {
        Random rnd = new Random();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите размер списка: ");
        int size=scanner.nextInt();
        for (int i = 0; i <size; i++) {
            arr.add(i);
            arr.set(i, rnd.nextInt(-10, 11));
        }
        scanner.close();
        return arr;
    }

    public static Integer maxValue(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }

    public static Integer minValue(ArrayList<Integer> arr) {
        int min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }

    public static Double averageValue(ArrayList<Integer> arr) {
        Double aver = 0.;
        for (int i = 0; i < arr.size(); i++) {
            aver += arr.get(i);
        }
        aver = aver / arr.size();
        return aver;
    }

}
