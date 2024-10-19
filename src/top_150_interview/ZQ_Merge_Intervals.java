package top_150_interview;

import java.util.*;

public class ZQ_Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(new int[] {intervals[0][0], intervals[0][1]});

        int a, b;
        int lastA, lastB;
        for (int i = 1; i < intervals.length; i++) {
            a = intervals[i][0];
            b = intervals[i][1];

            lastA = res.get(res.size()-1)[0];
            lastB = res.get(res.size()-1)[1];

            if (a <= lastB) {
                if (b > lastB) {
                    res.remove(res.size() - 1);
                    res.add(new int[] {lastA, b});
                }
            } else {
                res.add(new int[] {a, b});
            }
        }

        int[][] resArr = new int[res.size()][2];
        for (int i= 0; i < res.size(); i++) {
            resArr[i][0] = res.get(i)[0];
            resArr[i][1] = res.get(i)[1];
        }
        return resArr;
    }
}
