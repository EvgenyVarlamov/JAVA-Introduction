package ru.geekbrains;

import java.util.*;

public class InfixToPostfixInterpreter {
    /*
     ***** Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
     http://primat.org/news/obratnaja_polskaja_zapis/2016-04-09-1181 Вычислить запись если это возможно.
     x^y/(5+z)+8 --> xy^5z+/8+
     7^3/(5+2)+8 --> 73^52+/8+
     */

    static Deque<String> infixToPostfix(String equation) {
        Deque<String> postfix = new LinkedList<>();
        Deque<Character> operation = new LinkedList<>();
        Map<Character, Integer> priority = new HashMap<>(Map.of('+', 1, '-', 1, '*', 2, '/', 2, '^', 3));
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) != '+' && equation.charAt(i) != '-' && equation.charAt(i) != '*' && equation.charAt(i) != '/' && equation.charAt(i) != '^' && equation.charAt(i) != '(' && equation.charAt(i) != ')') {
                postfix.offer(String.valueOf(equation.charAt(i)));
            } else if (equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '*' || equation.charAt(i) == '/' || equation.charAt(i) == '^') {
                if (operation.isEmpty() || operation.peekLast() == '(') {
                    operation.push(equation.charAt(i));
                } else if (priority.get(equation.charAt(i)) > priority.get(operation.peekLast())) {
                    operation.push(equation.charAt(i));
                } else if (priority.get(equation.charAt(i)) <= priority.get(operation.peekLast())) {
                    if (operation.element() != '(') {
                        postfix.offer(String.valueOf(operation.pop()));
                    }
                    operation.push(equation.charAt(i));
                }
            } else if (equation.charAt(i) == '(') {
                operation.push(equation.charAt(i));
            } else if (equation.charAt(i) == ')') {
                while (operation.size() > 0 && operation.element() != '(') {
                    postfix.offer(String.valueOf(operation.pop()));
                }
                if (operation.size() > 0 && operation.element() == '(') {
                    operation.pop();
                }
            }
        }
        postfix.offer(String.valueOf(operation.pop()));
        return postfix;
    }

    public static void main(String[] args) {
        Deque<String> interpretation1 = infixToPostfix("7^3/(5+2)+8");
        System.out.println(interpretation1);
        Deque<String> interpretation2 = infixToPostfix("5*6+(2-9)");
        System.out.println(interpretation2);
    }

}
