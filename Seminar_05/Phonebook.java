package ru.geekbrains;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook<T> {
    /*
    Реализуйте структуру телефонной книги с помощью HashMap,
    учитывая, что 1 человек может иметь несколько телефонов.
     */

    private Map<String, List<Integer>> phoneList = new HashMap<>();

    public Phonebook() {
        this.phoneList = new HashMap<>();
    }

    public void addPhone(String name, Integer... phone) {
        this.phoneList.put(name, List.of(phone));
    }

    public void removePhone(String name) {
        this.phoneList.remove(name);
    }

    public void output() {
        for (Map.Entry<String, List<Integer>> item : this.phoneList.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.addPhone("Ivanov Ivan", 12345, 54321);
        phonebook.addPhone("Kurtei Jan", 78678, 786678, 4567);
        phonebook.addPhone("Berni Oldrich", 5467);
        phonebook.output();
        System.out.println();
        phonebook.removePhone("Ivanov Ivan");
        phonebook.output();
    }
}
