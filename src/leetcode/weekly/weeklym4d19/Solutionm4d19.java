package leetcode.weekly.weeklym4d19;/**
 * @description Solutionm4d19
 * @author liusandao
 * @date 2020-4-19 10:40
 */

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-19 10:40
 */

public class Solutionm4d19 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> menu = new ArrayList<>();
        List<List<String>> ans = new ArrayList<List<String>>();
        Set<String> set = new HashSet<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {
            int table_num = Integer.valueOf(orders.get(i).get(1));
            String food = orders.get(i).get(2);
            set.add(food);
            if (!map.containsKey(table_num)){
                List<String> n = new ArrayList<>();
                n.add(food);
                map.put(table_num,n);
            }
            else {
                List<String> n = map.get(table_num);
                n.add(food);
            }
        }
        for(String s : set){
            menu.add(s);
        }
        Collections.sort(menu, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        menu.add(0,"Table");
        for (Map.Entry<Integer,List<String>> m : map.entrySet()) {
            List<String> t = new ArrayList<>();
            t.add(String.valueOf(m.getKey()));
            int[] o = new int[menu.size() - 1];
            for (int i = 0; i < m.getValue().size(); i++) {
                for(int j = 0; j < menu.size() - 1; j++){
                    if (m.getValue().get(i).equals(menu.get(j+1))){
                        o[j]++;
                        break;
                    }
                }
            }
            for (int i = 0; i < o.length; i++) {
                t.add(String.valueOf(o[i]));
            }
            ans.add(t);
        }
        ans.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return Integer.valueOf(o1.get(0)) - Integer.valueOf(o2.get(0));
            }
        });
        ans.add(0,menu);
        return ans;

    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int finished = 0;
        int[] cr = new int[5];
        int n = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            if (croakOfFrogs.charAt(i) == 'c' && finished == 0){
                n++;
                cr[0]++;
            }
            else if(croakOfFrogs.charAt(i) == 'c' && finished != 0){
                finished--;
                cr[0]++;
            }
            else if(croakOfFrogs.charAt(i) == 'r'){
                if (cr[0] == 0){
                    return -1;
                }
                else {
                    cr[0]--;
                    cr[1]++;
                }
            }
            else if(croakOfFrogs.charAt(i) == 'o'){
                if (cr[1] == 0){
                    return -1;
                }
                else {
                    cr[1]--;
                    cr[2]++;
                }
            }
            else if(croakOfFrogs.charAt(i) == 'a'){
                if (cr[2] == 0){
                    return -1;
                }
                else {
                    cr[2]--;
                    cr[3]++;
                }
            }
            else if(croakOfFrogs.charAt(i) == 'k'){
                if (cr[3] == 0){
                    return -1;
                }
                else {
                    cr[3]--;
                    finished++;
                }
            }
            else {
                return -1;
            }
        }
        for (int i = 0; i < cr.length; i++) {
            if (cr[i] != 0){
                return -1;
            }
        }
        return n;
    }

    public int numOfArrays(int n, int m, int k) {
        //最大数前面，有k-1个递增的没他大的数，最大数后面，全是比他小的数
        //又由于 1<=arr[i]<=m ，即arr[i]有m个取值
        //需要k-1个递增的没他大的数，那么至少排在第k位，且最小为k，所以k > m 输出 0, k > n 输出 0

        //dp[n][m]
        // dp[k][k] = 1        1,2,3,...,k
        // dp[k][k+1]          dp[k][k]   +   从k+1 - 1个数中，挑选出k-1个  (k+1)
        // dp[k][k+2]          dp[k][k+1]  +   从k+2 - 1个数中，挑选出k-1个  (k+2)
        // dp[k][m]            dp[k][m-1]   +   从m-1个数中，挑选出k-1个      (m)

        // dp[k+1][k]          在dp[k][k]的基础上，插入一个数，并不改变性质
        //                        插入的位置有k+1-1个
        //                        (1 + 2 + 3 +... + k) * dp[k][k][k]
        // dp[k+1][k+1]
        return 0;
    }

}
