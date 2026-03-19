package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int capacity=12;
    private static final int empty=-1;
    private int[] numbers = new int[capacity];

    public int total = empty;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean isEmpty() {
        return total == empty;
    }

    public boolean isFull() {
        return total == capacity+empty;
    }

    protected int top() {
        if (isEmpty())
            return empty;
        return numbers[total];
    }

    public int countOut() {
        if (isEmpty())
            return empty;
        return numbers[total--];
    }

}
