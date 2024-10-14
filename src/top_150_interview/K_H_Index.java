package top_150_interview;

import java.util.Arrays;

public class K_H_Index {
    public static int hIndex(int[] citations) {
        // Bước 1: Sắp xếp mảng trích dẫn theo thứ tự giảm dần
        Arrays.sort(citations);

        // Bước 2: Tìm H-Index
        int n = citations.length;
        int h = 0;
        for (int i = 0; i < n; i++) {
            int citationCount = citations[n - 1 - i]; // Số trích dẫn của bài thứ (n-1-i) sau khi sắp xếp
            if (citationCount >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        int[] citations = {1,3,1};
        System.out.println(hIndex(citations));
    }
}
