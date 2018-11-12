// given a set of intervals, insert a new interval and merge if necessary
// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

package Arrays;

import java.util.List;

public class MergeIntervals {
    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> solution(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        Interval tmpInterval = null;

        // find a position to insert the new interval
        while (i < intervals.size() && intervals.get(i).end <= newInterval.start) {
            i++;
        }

        // now start merging the intervals until the new interval doesnt overlap
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            tmpInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                                                Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }

        // now insert the newly created interval
        intervals.add(i, tmpInterval);

        return intervals;
    }
}
