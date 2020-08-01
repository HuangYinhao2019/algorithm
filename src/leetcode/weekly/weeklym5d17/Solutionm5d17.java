package leetcode.weekly.weeklym5d17;/**
 * @description Solutionm5d17
 * @author liusandao
 * @date 2020-5-17 10:33
 */

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-17 10:33
 */

public class Solutionm5d17 {

    public int max = -1;

    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] str = text.split(" ");
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i] + " ");
        }
        String ans = sb.toString().trim();
        ans = ans.substring(0,1).toUpperCase().concat(ans.substring(1));
        return ans;
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (int j = 0; j < favoriteCompanies.get(i).size(); j++) {
                String web = favoriteCompanies.get(i).get(j);
                if (!map.containsKey(web)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(web, list);
                } else {
                    map.get(web).add(i);
                }
            }
        }
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            int[] t = new int[100];
            for (int j = 0; j < favoriteCompanies.get(i).size(); j++) {
                String web = favoriteCompanies.get(i).get(j);
                List<Integer> list = map.get(web);
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k) != i) {
                        t[list.get(k)]++;
                    }
                }
            }
            boolean sub = false;
            for (int j = 0; j < 100; j++) {
                if (j != i && t[j] == favoriteCompanies.get(i).size()){
                    sub = true;
                    break;
                }
            }
            if (!sub){
                ans.add(i);
            }
        }
        return ans;
    }

    public int numPoints(int[][] points, int r) {
        boolean[][] dis = new boolean[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            dis[i][i] = true;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < 4 * r * r){
                    dis[i][j] = true;
                    dis[j][i] = true;
                } else {
                    dis[i][j] = false;
                    dis[j][i] = false;
                }
            }
        }
        traceBack(0, dis, new HashSet<>());
        return max;
    }

    public void traceBack(int index, boolean[][] dis, HashSet<Integer> set){
        if (index >= dis.length){
            max = Math.max(max, set.size());
            return;
        } else if (max >= set.size() + dis.length - index){
            return;
        }
        boolean t = true;
        for (Integer e : set){
            if (!dis[index][e]){
                t = false;
                break;
            }
        }
        if (t){
            set.add(index);
            traceBack(index + 1, dis, set);
            set.remove(index);
            traceBack(index + 1, dis, set);
        } else {
            traceBack(index + 1, dis, set);
        }
    }

    public static void main(String[] args) {
        Solutionm5d17 s = new Solutionm5d17();
        int[][] points = new int[][]{{-23,0},{23,22},{15,1},{-15,2},{30,-25},{2,19},{18,12},{9,21},{17,11},{20,-22},{-21,26},{25,0},{-18,15},{16,-18},{-5,-6},{10,4},{18,-20},{-19,-8},{-14,-28},{-5,3},{-16,-10},{-7,1}};
        System.out.println(s.numPoints(points, 23));
    }

}
