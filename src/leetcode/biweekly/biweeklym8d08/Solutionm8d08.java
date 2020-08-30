package leetcode.biweekly.biweeklym8d08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-08 22:24
 */

public class Solutionm8d08 {

    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1, j = 0; i < 1003;) {
            if (j < arr.length && i == arr[j]) {
                j++;
                i++;
            } else {
                list.add(i);
                i++;
            }
        }
        return list.get(k - 1);
    }

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] times = new int[26];
        Arrays.fill(times, k / 26);
        k %= 26;
        for (int i = 0; i < k; i++) {
            times[i]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (t.charAt(i) != s.charAt(i)) {
                int c = (t.charAt(i) + 26 - s.charAt(i)) % 26;
                times[c]--;
                if (times[c] < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        s = s.replaceAll("\\)\\)", "]");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                res++;
            }
        }
        s = s.replaceAll("\\)", "]");
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (stack.peek() == '(' && s.charAt(i) == ']') {
                stack.pop();
                continue;
            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            if (pop == '(') {
                res += 2;
            } else {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solutionm8d08 s = new Solutionm8d08();
        System.out.println(s.minInsertions(")))))))"));
    }

}
