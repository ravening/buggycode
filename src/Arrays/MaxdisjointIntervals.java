package src.Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/maximal-disjoint-intervals/
 */
public class MaxdisjointIntervals {
    public void solution(IntervalPair[] pairs) {
        Arrays.sort(pairs, (x1, x2) -> {
            if (x1.getEnd() > x2.getEnd()) {
                return 1;
            }
            if (x1.getEnd() == x2.getEnd())
                return 0;

            return -1;
        });

        System.out.print(pairs[0] + " ");

        int r = pairs[0].end;

        for (var i= 1; i < pairs.length; i++) {
            if (pairs[i].start > r) {
                System.out.print(pairs[i] + " ");
                r = pairs[i].end;
            }
        }
    }
}

class IntervalPair {
    int start;
    int end;

    public IntervalPair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
