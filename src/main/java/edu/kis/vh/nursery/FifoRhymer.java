package edu.kis.vh.nursery;

public class FifoRhymer extends DefaultCountingOutRhymer {

    public DefaultCountingOutRhymer tempRhymer = new DefaultCountingOutRhymer();

    @Override
    public int countOut() {
        while (!isEmpty())

            tempRhymer.countIn(super.countOut());

        int ret = tempRhymer.countOut();

        while (!tempRhymer.isEmpty())
            countIn(tempRhymer.countOut());

        return ret;
    }
}
