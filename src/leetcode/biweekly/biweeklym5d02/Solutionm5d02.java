package leetcode.biweekly.biweeklym5d02;/**
 * @description Solutionm5d02
 * @author liusandao
 * @date 2020-5-2 20:36
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-02 20:36
 */

public class Solutionm5d02 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i],max);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public int maxDiff(int num) {
        String a = String.valueOf(num);
        char x = '9', y = '9';
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '9'){
                x = a.charAt(i);
                break;
            }
        }
        a = a.replace(x, y);
        String b = String.valueOf(num);
        x = '-';
        if (b.charAt(0) != '1'){
            b = b.replace(b.charAt(0), '1');
        }
        else {
            for (int i = 1; i < b.length(); i++){
                if (b.charAt(i) != '0' && b.charAt(i) != b.charAt(0)){
                    x = b.charAt(i);
                    break;
                }
            }
            if (x != '-') {
                b = b.replace(x, '0');
            }
        }
        return Integer.valueOf(a) - Integer.valueOf(b);

    }

    public boolean checkIfCanBreak(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int m = Math.max(arr1[i],arr2[i]);
            arr1[i] -= m;
            arr2[i] -= m;
        }
        return canBreak(arr1, arr2) || canBreak(arr2, arr1);
    }

    public boolean canBreak(int[] arr1, int[] arr2){
        int sum = 0;
        for (int i = 25; i >= 0; i--) {
            sum += arr1[i] - arr2[i];
            if (sum < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solutionm5d02 s = new Solutionm5d02();
    }

}
