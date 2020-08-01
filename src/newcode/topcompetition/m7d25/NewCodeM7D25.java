package newcode.topcompetition.m7d25;/**
 * @description NewCodeM7D25
 * @author liusandao
 * @date 2020-7-25 20:55
 */

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-07-25 20:55
 */

public class NewCodeM7D25 {

    public long rotateRight (String str, int k) {
        String s = str.substring(str.length() - k) + str.substring(0, str.length() - k);
        long res = 0;
        for (int l = s.length() - 1; l >= 0; l--) {
            if (s.charAt(l) == '1'){
                res += (long)Math.pow(2, s.length() - 1 - l);
            }
        }
        return res;
    }

    public int solve1 (int n, int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int sum;
        for (int i = 0; i < n; i++) {
            if (!set.contains(a[i]) && a[i] % 2 == 0){
                int k = a[i];
                int count = 0;
                while (k % 2 == 0){
                    k /= 2;
                    count++;
                }
                if (!map.containsKey(k) || map.get(k) < count) {
                    map.put(k, count);
                }
            }
            set.add(a[i]);
        }
        Collection<Integer> values = map.values();
        sum = values.stream().mapToInt(x -> x).sum();
        return sum;
    }

    public int solve (int n, int[] array) {
        Arrays.sort(array);
        int max = -1;
        int left = array[0], right = array[0];
        for (int i = 1; i < n; i++) {
            if (left < right) {
                max = Math.max(array[i] - left, max);
                left = array[i];
            } else {
                max = Math.max(array[i] - right, max);
                right = array[i];
            }
        }
        max = Math.max(Math.abs(left - right), max);
        return max;
    }

    public static void main(String[] args) {
        NewCodeM7D25 n = new NewCodeM7D25();
        System.out.println(n.solve(3, new int[]{2,2,3}));
    }

}
