package exam.written.netease;

import java.util.*;

/**
 * @author liusandao
 * @description NeTease3
 * @date 2020-4-7 19:48
 */
public class NeTease3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //人数，聚会次数，初始编号
        int N, M, F;
        N = sc.nextInt();
        M = sc.nextInt();
        F = sc.nextInt();
        sc.nextLine();

        int[] ill = new int[N];
        for (int i = 0; i < N; i++) {
            ill[i] = i;
        }

        List<Integer>[] list = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<Integer>();
            String s = sc.nextLine();
            String[] str = s.split(" ");
            for (int j = 1; j < str.length; j++) {
                list[i].add(Integer.valueOf(str[j]));
            }
        }

        for (int i = 0; i < M; i++) {
            int first = list[i].get(0);
            int index = ill[first];
            for (int j = 1; j < list[i].size(); j++) {
                int indexj = ill[list[i].get(j)];
                for (int k = 0; k < N; k++) {
                    if (ill[k] == indexj){
                        ill[k] = index;
                    }
                }
            }
        }

        int ans = 0;
        int group = ill[F];
        for (int i = 0; i < N; i++) {
            if (ill[i] == group){
                ans++;
            }
        }
        System.out.println(ans);

    }

}
