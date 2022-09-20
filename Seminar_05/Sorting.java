package ru.geekbrains;

import java.util.*;

public class Sorting {
    /*
    Написать программу, которая найдет и выведет повторяющиеся имена
    с количеством повторений. Отсортировать по убыванию популярности.
     */
    public static LinkedList<String> employeeList = new LinkedList<>(List.of("Иван Иванов",
                                                                                "Светлана Петрова",
                                                                                "Кристина Белова",
                                                                                "Анна Мусина",
                                                                                "Анна Крутова",
                                                                                "Иван Юрин",
                                                                                "Петр Лыков",
                                                                                "Павел Чернов",
                                                                                "Петр Чернышов",
                                                                                "Мария Федорова",
                                                                                "Марина Светлова",
                                                                                "Мария Савина",
                                                                                "Мария Рыкова",
                                                                                "Марина Лугова",
                                                                                "Анна Владимирова",
                                                                                "Иван Мечников",
                                                                                "Петр Петин",
                                                                                "Иван Ежов"));

    public static TreeSet<String> searchSort(LinkedList<String> empployeeName) {
        ArrayList<Integer> compare=new ArrayList<>();
        for (int i = 0; i < empployeeName.size(); i++) {
            empployeeName.set(i,empployeeName.get(i).substring(0, empployeeName.get(i).indexOf(" ")));
        }
        int count=0;
        for (int i = 0; i < empployeeName.size(); i++) {
            for (int j = 0; j < empployeeName.size(); j++) {
                if(empployeeName.get(i).equals(empployeeName.get(j))){
                    count++;
                }
            }
            compare.add(count);
            count=0;
        }
        TreeSet<String> employeeSort=new TreeSet<>();
        for (int i = 0; i < empployeeName.size(); i++) {
            if (!compare.get(i).equals(1)) {
                employeeSort.add(compare.get(i) + " повтора(ов): " + empployeeName.get(i));
            }
        }
        return employeeSort;
    }

    public static void main(String[] args) {
        System.out.println(searchSort(employeeList));
    }
}
