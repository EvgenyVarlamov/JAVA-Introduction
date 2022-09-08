package ru.geekbrains;

public class Task3 {
    /*
    3**** Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
     */
    public StringBuilder[] parseString(StringBuilder txt) {

        int count = 1;
        String temp1 = "фамилия";
        String temp2 = "оценка";
        String temp3 = "предмет";

        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '"') {
                txt.deleteCharAt(i);
            }
            if (txt.charAt(i) == ':') {
                txt.replace(i, i + 1, " ");
            }
            if (i < txt.length() - temp1.length()) {
                String check1 = String.valueOf(txt.substring(i, i + temp1.length()));
                if (check1.equals(temp1)) {
                    txt.replace(i, i + temp1.length(), "Студент");
                }
            }
            if (i < txt.length() - temp2.length()) {
                String check2 = String.valueOf(txt.substring(i, i + temp2.length()));
                if (check2.equals(temp2)) {
                    txt.replace(i, i + temp2.length(), " получил");
                }
            }
            if (i < txt.length() - temp3.length()) {
                String check3 = String.valueOf(txt.substring(i, i + temp3.length()));
                if (check3.equals(temp3)) {
                    txt.replace(i, i + temp3.length(), " по Предмету");
                }
            }
            if (txt.charAt(i) == ',' && txt.charAt(i + 1) == '{') {
                count++;
            }
        }

        StringBuilder[] str = new StringBuilder[count];

        for (int i = 0; i < str.length; i++) {
            str[i] = new StringBuilder("");
        }

        int a = 0;
        for (int i = 0; i < txt.length(); i++) {
            str[a].append(txt.charAt(i));
            if (txt.charAt(i) == ',' && txt.charAt(i - 1) == '}') {
//                str[a].deleteCharAt(str[a].lastIndexOf(""));
                str[a].deleteCharAt(str[a].lastIndexOf(","));
                a++;
                continue;
            }
        }

        for (int i = 0; i < str.length; i++) {

            while (str[i].indexOf(",") != -1) {
                str[i].deleteCharAt(str[i].indexOf(","));
            }
            str[i].deleteCharAt(str[i].indexOf("{"));
            str[i].deleteCharAt(str[i].indexOf("}"));
        }
        return str;
    }

    public static void main(String[] args) {
        StringBuilder jsonString = new StringBuilder("{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}");
        Task3 t = new Task3();
        StringBuilder[] arr = t.parseString(jsonString);
        for (StringBuilder item : arr) {
            System.out.println(item);
        }

    }

}
