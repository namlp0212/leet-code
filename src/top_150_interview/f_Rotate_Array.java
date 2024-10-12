package top_150_interview;

public class f_Rotate_Array {
    public static void rotateV1(int[] nums, int k) {
        int len = nums.length;
        int mod = k % len;

        int a[] = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            if (i < mod) {
                nums[i] = a[i + len - mod];
            } else {
                nums[i] = a[i - mod];
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void rotateV2(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void reverse(int[] nums,int start,int end)
    {
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        rotateV2(nums, 2);
    }
}
