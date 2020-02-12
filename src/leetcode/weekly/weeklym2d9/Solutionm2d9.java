package leetcode.weekly.weeklym2d9;

import java.util.HashMap;

public class Solutionm2d9 {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!m.containsKey(arr[i]))
                m.put(arr[i],1);
            else
                m.put(arr[i],m.get(arr[i])+1);
        }
        if (m.containsKey(0) && m.get(0) > 1)
            return true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && m.containsKey(arr[i] * 2))
                return true;
        }
        return false;
    }

    public int minSteps(String s, String t) {
        int[] ss = new int [26];
        int[] tt = new int [26];
        for (int i = 0; i < s.length(); i++) {
            ss[s.charAt(i)-'a']++;
            tt[t.charAt(i)-'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(ss[i]-tt[i]);
        }
        return ans/2;
    }

    public static void main(String[] args) {
        Solutionm2d9 s = new Solutionm2d9();
        String a = "friend";
        String t = "family";
        System.out.println(s.minSteps(a, t));
    }
}
