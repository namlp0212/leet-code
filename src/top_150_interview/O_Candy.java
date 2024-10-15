package top_150_interview;

public class O_Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        candy[0] = 1;

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            } else {
                candy[i] = 1;
            }
        }

        for (int i = len-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) {
                candy[i] = candy[i+1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += candy[i];
        }

        return res;
    }
}
