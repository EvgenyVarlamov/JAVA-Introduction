package ru.geekbrains;

import java.io.*;

public class Task1 {
    /*
    1. Напишите метод, который определит тип (расширение) файлов
    из текущей папки и выведет в консоль результат вида
1 Расширение файла: txt
2 Расширение файла: pdf
3 Расширение файла:
4 Расширение файла: jpg
     */
    public static void main(String[] args) {
        File dir = new File("G:\\GB\\08 Java\\00 Introduction\\Seminar_02\\Homework\\src\\main\\java\\ru\\geekbrains");
        String str = "";
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    str += item.getName() + "\"";
                } else {
                    str += item.getName() + "\"";
                }
            }
        }
        String[] s = str.split("\"");
        for (String item : s) {
            System.out.println("Расширение файла: " + item + " => " + fileExtension(item));
        }
    }

    public static String fileExtension(String fileName) {
        String extension;
        try {
            extension = fileName.substring(fileName.lastIndexOf("."));
        } catch (Exception ex) {
            extension = "";
        }
        return extension;
    }
}