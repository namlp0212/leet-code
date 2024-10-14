package top_150_interview;

import com.sun.source.tree.Tree;

import java.util.*;

public class l_RandomizedSet {
    // ArrayList để lưu các phần tử
    private List<Integer> nums;
    // HashMap để lưu vị trí của các phần tử trong ArrayList
    private Map<Integer, Integer> map;
    private Random rand;

    /** Khởi tạo cấu trúc dữ liệu. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Thêm một phần tử vào tập hợp. Trả về true nếu phần tử chưa tồn tại. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // Phần tử đã tồn tại
        }
        map.put(val, nums.size()); // Thêm phần tử và lưu vị trí vào HashMap
        nums.add(val); // Thêm vào cuối ArrayList
        return true;
    }

    /** Xóa một phần tử. Trả về true nếu phần tử tồn tại. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Phần tử không tồn tại
        }
        int index = map.get(val); // Vị trí của phần tử cần xóa
        int lastElement = nums.get(nums.size() - 1); // Phần tử cuối trong ArrayList

        // Di chuyển phần tử cuối đến vị trí của phần tử cần xóa
        nums.set(index, lastElement);
        map.put(lastElement, index);

        // Xóa phần tử cuối
        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }

    /** Trả về một phần tử ngẫu nhiên từ tập hợp. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
