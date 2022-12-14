package ru.geekbrains;

public class Task2 {
    /*
    2. Дана строка sql-запроса "select * from students where ".
    Сформируйте часть WHERE этого запроса, используя StringBuilder.
    Данные для фильтрации приведены ниже в виде json строки.
    Если значение null, то параметр не должен попадать в запрос.
    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Ответ: "select * from students where name = 'Ivanov' and country = 'Russia' and city = 'Moscow'" для приведенного примера
     */
    public StringBuilder stringRestruct(StringBuilder txt) {

        int count = 1;
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == ',') {
                count++;
            }
        }

        StringBuilder[] arrKey = new StringBuilder[count];
        StringBuilder[] arrVal = new StringBuilder[count];
        for (int i = 0; i < arrKey.length; i++) {
            arrKey[i] = new StringBuilder("");
            arrVal[i] = new StringBuilder("");
        }

        int a = 0;

        for (int i = 0; i < txt.length(); i++) {

            arrKey[a].append(txt.charAt(i));
            arrVal[a].append(txt.charAt(i));
            if (txt.charAt(i) == ',') {
                txt.deleteCharAt(i);
                a++;
                continue;
            }

        }
        arrKey[arrKey.length - 1].append(',');
        arrVal[arrVal.length - 1].append(',');
        for (int i = 0; i < arrKey.length; i++) {
            arrKey[i].replace(arrKey[i].indexOf(":"), arrKey[i].lastIndexOf(",") + 1, "");
            arrKey[i].deleteCharAt(arrKey[i].indexOf("\""));
            arrKey[i].deleteCharAt(arrKey[i].lastIndexOf("\""));
            arrVal[i].replace(arrVal[i].indexOf("\""), arrVal[i].lastIndexOf(":") + 2, "'");
            arrVal[i].replace(arrVal[i].lastIndexOf("\""), arrVal[i].lastIndexOf(",") + 1, "'");
        }

        StringBuilder newTxt = new StringBuilder("");
        String check = "'null'";
        for (int i = 0; i < arrKey.length; i++) {
            String temp = String.valueOf(arrVal[i]);
            if (temp.equals(check)) {
                continue;
            }
            newTxt.append(arrKey[i]).append(" = ").append(arrVal[i].append(" and "));
        }
        newTxt.replace(newTxt.lastIndexOf(" and "), newTxt.lastIndexOf(" "), "");

        return newTxt;
    }

    public static void main(String[] args) {
        StringBuilder sql = new StringBuilder("select * from students where ");
        StringBuilder jsonString = new StringBuilder("\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"");
        Task2 s = new Task2();
        System.out.println(sql.append(s.stringRestruct(jsonString)));
    }
}