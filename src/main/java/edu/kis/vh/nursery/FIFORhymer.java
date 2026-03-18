package edu.kis.vh.nursery;

public class FIFORhymer extends defaultCountingOutRhymer {

    public defaultCountingOutRhymer tempRhymer = new defaultCountingOutRhymer();

    @Override
    public int countOut() {
        while (!callCheck())

            tempRhymer.countIn(super.countOut());

        int ret = tempRhymer.countOut();

        while (!tempRhymer.callCheck())

            countIn(tempRhymer.countOut());

        return ret;
    }
}
