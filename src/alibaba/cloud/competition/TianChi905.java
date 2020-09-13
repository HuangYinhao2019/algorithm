package alibaba.cloud.competition;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-09-05 11:01
 */

public class TianChi905 {

//    public long greatestcommonmultiple(int a, int b) {
//        // write your code here
//    }

    public int perfectString(String s, int k) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                if (count != 0) {
                    ans += (count - 1) / k + 1;
                }
                count = 0;
            }
        }
        if (count != 0) {
            ans += (count - 1) / k + 1;
        }
        return ans;
    }

    public boolean stringGame(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        int count = 0;
        int flag = 0;
        int n = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0){
                n++;
                count ^= c[i];
                if (c[i] > 1) {
                    flag = 1;
                }
            }
        }
        return flag == 0 ? n % 2 == 0 : count != 0;
    }

    public static void main(String[] args) {
        TianChi905 tianChi905 = new TianChi905();
        System.out.println(tianChi905.perfectString("10101", 2));
    }
}
