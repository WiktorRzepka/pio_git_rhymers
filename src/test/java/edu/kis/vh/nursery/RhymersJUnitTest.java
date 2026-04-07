package edu.kis.vh.nursery;

import edu.kis.vh.nursery.list.IntLinkedList;
import org.junit.Assert;
import org.junit.Test;
//TODO: needs more tests to validate whole project.
public class RhymersJUnitTest {

    // Projekt jest poprawny - wszystkie testy kończą się pozytywnie.
    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.top();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.isEmpty();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.isEmpty();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.top();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.top();
        Assert.assertEquals(testValue, result);
        result = rhymer.top();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    // Testy dla klasy IntLinkedList
    @Test
    public void testPush() {
        IntLinkedList linkedList = new IntLinkedList();

        linkedList.push(67);
        Assert.assertEquals(linkedList.top(), 67);
    }

    @Test
    public void testPop() {
        IntLinkedList linkedList = new IntLinkedList();

        linkedList.push(67);
        Assert.assertEquals(linkedList.pop(), 67);
    }

    @Test
    public void testIsEmpty() {
        IntLinkedList linkedList = new IntLinkedList();

        Assert.assertEquals(linkedList.isEmpty(), true);
        linkedList.push(67);
        Assert.assertEquals(linkedList.isEmpty(), false);
    }

    @Test
    public void testEmptyOperations() {
        IntLinkedList list = new IntLinkedList();

        Assert.assertEquals(-1, list.pop());
        Assert.assertEquals(-1, list.top());
    }

    @Test
    public void testIsFullAlwaysFalse() {
        IntLinkedList list = new IntLinkedList();

        Assert.assertFalse(list.isFull());
    }

    @Test
    public void testMultipleElementsPushAndPop() {
        IntLinkedList linkedList = new IntLinkedList();

        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);

        Assert.assertEquals(3, linkedList.top());
        Assert.assertEquals(3, linkedList.pop());
        Assert.assertEquals(2, linkedList.top());
        Assert.assertEquals(2, linkedList.pop());
        Assert.assertEquals(1, linkedList.top());
        Assert.assertEquals(1, linkedList.pop());

        Assert.assertTrue(linkedList.isEmpty());
        Assert.assertEquals(-1, linkedList.pop());
    }

    @Test
    public void testMixedPushAndPop() {
        IntLinkedList linkedList = new IntLinkedList();

        linkedList.push(1);
        Assert.assertEquals(1, linkedList.pop());

        linkedList.push(2);
        linkedList.push(3);
        Assert.assertEquals(3, linkedList.pop());

        linkedList.push(4);
        Assert.assertEquals(4, linkedList.pop());
        Assert.assertEquals(2, linkedList.pop());

        Assert.assertTrue(linkedList.isEmpty());
    }
}

