package top_150_interview;

import java.util.Stack;

public class ZV_Simplify_Path {
    public static String simplifyPath(String path) {
        // Tạo một stack để lưu các phần của đường dẫn
        Stack<String> stack = new Stack<>();

        // Tách các phần của đường dẫn dựa trên dấu '/'
        String[] parts = path.split("/");

        // Duyệt qua từng phần của đường dẫn
        for (String part : parts) {
            // Bỏ qua các phần rỗng hoặc là '.'
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Nếu phần là '..', ta pop khỏi stack nếu không rỗng
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Nếu là tên thư mục hợp lệ, ta push vào stack
                stack.push(part);
            }
        }

        // Xây dựng lại đường dẫn từ stack
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // Nếu stack rỗng, trả về "/"
        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
    }
}
