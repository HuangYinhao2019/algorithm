package leetcode.weekly.weeklym6d14;/**
 * @description Solutionm6d14
 * @author liusandao
 * @date 2020-6-14 10:25
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-06-14 10:25
 */

public class Solutionm6d14 {

    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i] + ans[i - 1];
        }
        return ans;
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int[] num = new int[entries.size()];
        int i = 0;
        for (Map.Entry entry : entries){
            num[i++] = (int)entry.getValue();
        }
        Arrays.sort(num);
        int sum = 0;
        for (int j = 0; j < num.length; j++) {
            sum += num[j];
            if (sum > k){
                return num.length - j;
            }
        }
        return 0;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((double)m * (double)k > n){
            return -1;
        } else {
            int begin = 1, end = 1000000000;
            while (begin < end){
                int mid = (begin + end) / 2;
                if (isEnoughFlower(bloomDay, m, k, mid)){
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            }
            return begin;
        }
    }

    private boolean isEnoughFlower(int[] bloomDay, int m, int k, int day){
        int number = 0;
        int now = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day){
                now++;
                if (now >= k){
                    number++;
                    now = 0;
                }
            } else {
                now = 0;
            }
        }
        if (number >= m){
            return true;
        } else {
            return false;
        }
    }

}
