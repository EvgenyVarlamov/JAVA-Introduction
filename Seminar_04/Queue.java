package ru.geekbrains;

public class Queue<T> {
    /*
   Написать реализацию очереди на основе массива;
   Реализовать методы size(), empty(), offer(), poll(), peek()
    */
    private T[] array;
    private int index = 0;

    public Queue(int length) {
        this.index = 0;
        this.array = (T[]) new Object[length];
    }

    public int size() {
        return this.index;
    }

    public boolean empty() {
        System.out.print("Deque is empty: ");
        return this.size() == 0;
    }

    public void offer(T value) {
        if (this.index < this.array.length) {
            this.array[index++] = value;
        } else {
            System.out.println("Array index out of bounds (+1)");
        }
    }

    public T peek() {
        if (size() > 0) {
            return this.array[0];
        } else {
            System.out.println("Queue element not found");
        }
        return null;
    }

    public T poll() {
        if (size() < 1) {
            System.out.println("Array index out of bounds (-1)");
        } else if (size() == 1) {
            return this.array[--index];
        } else if (size() > 1) {
            T temp = array[array.length - 1];
            this.array[array.length - 1] = this.array[0];
            this.array[0] = temp;
            return this.array[--index];
        }
        return null;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(5);
        System.out.println(queue.empty());
        queue.offer("Queue element 1");
        queue.offer("Queue element 2");
        System.out.println("size: " + queue.size());
        queue.offer("Queue element 3");
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        queue.offer("Queue element 4");
        queue.offer("Queue element 5");
        queue.offer("Queue element 6");
        System.out.println();
        while (queue.size() > 0) {
            System.out.println(queue.poll() + " ");
        }
        System.out.println();
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("size: " + queue.size());
        System.out.println(queue.peek());
    }
}
