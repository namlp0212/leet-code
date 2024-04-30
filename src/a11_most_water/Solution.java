package a11_most_water;

import java.util.List;

public class Solution {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, result = 0, minHeight = 0, area = 0;
        while (left < right) {
            minHeight = Math.min(height[left], height[right]);
            area = minHeight * (right - left);
            result = Math.max(area, result);

            while (left < right && height[left] <= minHeight) left++;
            while (left < right && height[right] <= minHeight) right--;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
