package top_150_interview;

import java.util.Arrays;
import java.util.*;

public class ZT_Minimum_Burst_Balloons {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int commonStart = points[0][0], commonEnd = points[0][1];

        int a, b, res = 1;
        for (int i = 1; i < points.length; i++) {
            a = points[i][0];
            b = points[i][1];
            if (commonStart <= a && a <= commonEnd) {
                commonStart = a;
                commonEnd = Math.min(b, commonEnd);
            } else {
                res++;
                commonStart = a;
                commonEnd = b;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1,2},{2,3},{3,4},{4,5}};

        System.out.println(findMinArrowShots(points));
    }
}
