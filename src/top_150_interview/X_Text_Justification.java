package top_150_interview;
import java.util.*;
public class X_Text_Justification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            // Tìm các từ có thể được đưa vào một dòng
            int totalChars = words[index].length();
            int last = index + 1;

            // Tính toán độ dài của dòng bằng cách thêm các từ cho đến khi vượt quá maxWidth
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length(); // 1 là cho khoảng trắng giữa các từ
                last++;
            }

            // Xây dựng dòng
            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;
            int numberOfSpaces = maxWidth - totalChars;

            // Nếu đây không phải dòng cuối cùng và có nhiều hơn một từ
            if (last != words.length && numberOfWords > 1) {
                int spacesBetweenWords = numberOfSpaces / (numberOfWords - 1); // Khoảng trắng cơ bản giữa các từ
                int extraSpaces = numberOfSpaces % (numberOfWords - 1);        // Phần dư khoảng trắng

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {  // Không thêm khoảng trắng sau từ cuối cùng
                        int spacesToApply = spacesBetweenWords + (i - index < extraSpaces ? 1 : 0);
                        for (int j = 0; j < spacesToApply + 1; j++) { // +1 cho khoảng trắng giữa các từ
                            line.append(" ");
                        }
                    }
                }
            } else {  // Nếu là dòng cuối hoặc chỉ có một từ
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(" ");
                    }
                }
                // Thêm khoảng trắng vào cuối dòng cho đủ `maxWidth`
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }

            result.add(line.toString());
            index = last; // Cập nhật index để xử lý nhóm từ tiếp theo
        }

        return result;
    }

    public static void main(String[] args) {
        String[] str = {"Listen","to","many,","speak","to","a","few."};
        System.out.println(fullJustify(str, 6));
    }
}
