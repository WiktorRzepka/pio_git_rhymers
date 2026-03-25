package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int CAPACITY=12;
    private static final int EMPTY =-1;
    private static final int STACK_EMPTY_INDEX=-1;
    private final int[] numbers = new int[CAPACITY];

    public int total = EMPTY;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean isEmpty() {
        return total == STACK_EMPTY_INDEX;
    }

    public boolean isFull() {
        return total == CAPACITY + EMPTY;
    }

    protected int top() {
        if (isEmpty())
            return EMPTY;
        return numbers[total];
    }

    public int countOut() {
        if (isEmpty())
            return EMPTY;
        return numbers[total--];
    }
}
