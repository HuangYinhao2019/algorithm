package alibaba.cloud.competition;

import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-30 09:59
 */

public class TianChi830 {

    public int Intervalxor(int[] num, List<List<Integer>> ask) {
        int xor = 0;
        for (int i = 0; i < ask.size(); i++) {
            List<Integer> integers = ask.get(i);
            int l1 = integers.get(0) - 1;
            int r1 = integers.get(1) - 1;
            int l2 = integers.get(2) - 1;
            int r2 = integers.get(3) - 1;
            int max = -1;
            int min = Integer.MAX_VALUE;
            for (int j = l1; j <= r1; j++) {
                max = Math.max(max, num[j]);
            }
            for (int j = l2; j <= r2; j++) {
                min = Math.min(min, num[j]);
            }
            xor ^= (max + min);
        }
        return xor;
    }

    public int Fivecharacterpalindrome(String s) {
        int ans = 0;
        for (int i = 0; i + 4 < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 4) && s.charAt(i + 1) == s.charAt(i + 3)
                    && s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2)
                    && s.charAt(i + 1) != s.charAt(i + 2)) {
                ans++;
            }
        }
        return ans;
    }

    public String castMagic(List<List<Integer>> triangle, int[] point) {
        if (point[0] == triangle.get(0).get(0) && point[1] == triangle.get(0).get(1)) {
            return "Yes";
        }
        if (point[0] == triangle.get(1).get(0) && point[1] == triangle.get(1).get(1)) {
            return "Yes";
        }
        if (point[0] == triangle.get(2).get(0) && point[1] == triangle.get(2).get(1)) {
            return "Yes";
        }

        double x1 = triangle.get(0).get(0);
        double y1 = triangle.get(0).get(1);
        double x2 = triangle.get(1).get(0);
        double y2 = triangle.get(1).get(1);
        double x3 = triangle.get(2).get(0);
        double y3 = triangle.get(2).get(1);

        double k1 = (y2 - y1) / (x2 - x1);
        double k2 = (y3 - y2) / (x3 - x2);
        double k3 = (y1 - y3) / (x1 - x3);

        double b1 = y1 - (k1 * x1);
        double b2 = y2 - (k2 * x2);
        double b3 = y3 - (k3 * x3);

        double x = point[0], y = point[1];

        double a1 = (y - (k1 * x) - b1) * (y3 - (k1 * x3) - b1);
        double a2 = (y - (k2 * x) - b2) * (y1 - (k2 * x1) - b2);
        double a3 = (y - (k3 * x) - b3) * (y2 - (k3 * x2) - b3);

        if (a1 > 0 && a2 > 0 && a3 > 0){
            return "Yes";
        } else if ((a1 == 0 && a2 > 0 && a3 > 0)
                || (a1 > 0 && a2 == 0 && a3 > 0)
                || (a1 > 0 && a2 > 0 && a3 == 0)) {
            return "Yes";
        }
        return "No";
    }

}
