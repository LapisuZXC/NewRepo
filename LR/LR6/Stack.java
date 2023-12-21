package LR6;

public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        data[size] = element;
        size += 1;
    }

    public T pop() {
        size -= 1;
        T value = data[size];
        data[size] = null;
        return value;
    }

    public T peek() {
        return data[size - 1];
    }
}
