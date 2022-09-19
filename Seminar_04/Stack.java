package ru.geekbrains;

class Stack<T> {
    /*
   Реализовать стэк с помощью массива.
   Нужно реализовать методы:
   size(), empty(), push(), peek(), pop().
   Взять за основу реализацию стека, написанную в конце семинара. Добавить проверку
   граничных условий и выводить сообщения об ошибках, если мы пытаемся извлечь
   элемент из пустого стека, добавить элемент в полностью заполненный стек и тд
    */
    /*
    Description:
    size() - array size;
    empty() - check of emptiness;
    push() - add element;
    peek() - output element;
    pop() - remove element.
     */
    private T[] array;
    private int index = 0;

    public Stack(int length) {
        this.index = 0;
        this.array = (T[]) new Object[length];
    }

    public int size() {
        return this.index;
    }

    public boolean empty() {
        System.out.print("Array is empty: ");
        return this.size() == 0;
    }

    public void push(T value) {
        if (this.index < this.array.length) {
            this.array[index++] = value;
        } else {
            System.out.println("Array index out of bounds (+1)");
        }
    }

    public T peek() {
        if(size()>0) {
            return this.array[index - 1];
        } else {
            System.out.println("Array element not found");
        }
        return null;
    }

    public T pop() {
        if (this.index > 0) {
            return this.array[--index];
        } else {
            System.out.println("Array index out of bounds (-1)");
        }
        return null;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(5);
        System.out.println("size: " + stack.size());
        System.out.println(stack.empty());
        stack.push("Array element 1");
        stack.push("Array element 2");
        stack.push("Array element 3");
        System.out.println(stack.empty());
        System.out.println(stack.peek());
        stack.push("Array element 4");
        stack.push("Array element 5");
        stack.push("Array element 6");
        System.out.println("size: " + stack.size());
        while (stack.size() > 0) {
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
