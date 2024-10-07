package top_150_interview;

import java.util.Arrays;

public class a_Merge_Sorted_Array {
    public static void mergeV1(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        int i1 = 0;
        int i2 = 0;
        int curIdx = 0;

        int[] clone1 = new int[m];
        for (int i  = 0; i < m; i++) {
            clone1[i] = nums1[i];
        }

        while (i1 < m || i2 < n) {
            if (i1 >= m) {
                while (i2 < n) {
                    nums1[curIdx] = nums2[i2];
                    curIdx++;
                    i2++;
                }
                i2++;
            } else if (i2 >= n) {
                while (i1 < m) {
                    nums1[curIdx] = clone1[i1];
                    curIdx++;
                    i1++;
                }
                i1++;
            } else {
                if (clone1[i1] < nums2[i2]) {
                    nums1[curIdx] = clone1[i1];
                    curIdx++;
                    i1++;
                } else if (clone1[i1] > nums2[i2]) {
                    nums1[curIdx] = nums2[i2];
                    curIdx++;
                    i2++;
                } else {
                    nums1[curIdx] = clone1[i1];
                    curIdx++;
                    i1++;
                    nums1[curIdx] = nums2[i2];
                    curIdx++;
                    i2++;
                }
            }
        }

        for (int i = 0; i < (n+m); i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    public static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int i1 = m-1;
        int i2 = n-1;
        int curIdx = n+m-1;

        while (i2 >= 0) {
            if (i1 >= 0 && nums1[i1] > nums2[i2]) {
                nums1[curIdx] = nums1[i1];
                i1--;
            } else {
                nums1[curIdx] = nums2[i2];
                i2--;
            }

            curIdx--;
        }

        for (int i = 0; i < (n+m); i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};

        mergeV2(nums1, 1, nums2, 1);
    }
}
