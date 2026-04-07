package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int CAPACITY=12;
    private static final int EMPTY =-1;
    private static final int STACK_EMPTY_INDEX=-1;
    private final int[] numbers = new int[CAPACITY];

    private int total = EMPTY;

    //TODO: method is not used, so it should be removed.
    public int getTotal() {
        return total;
    }

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
