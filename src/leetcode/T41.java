package leetcode;

public class T41 {
    public int firstMissingPositive(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) flag = true;
            if (nums[i] <= 0 || nums[i] > nums.length) nums[i] = 1;
        }
        if (!flag) return 1;
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) % nums.length] = -(Math.abs(nums[Math.abs(nums[i]) % nums.length]));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return nums.length;
        else return nums.length + 1;

    }

    public static void main(String[] args) {

    }
}
