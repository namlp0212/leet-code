package top_150_interview;

import java.util.*;

public class ZR_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Thêm tất cả intervals trước newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Hợp nhất các intervals chồng lấn với newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Thêm interval mới đã được hợp nhất
        result.add(newInterval);

        // Thêm các intervals sau newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Chuyển đổi List thành mảng 2 chiều
        return result.toArray(new int[result.size()][]);
    }
}
