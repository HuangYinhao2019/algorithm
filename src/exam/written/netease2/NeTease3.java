package exam.written.netease2;

import java.util.*;

/**
 * @author liusandao
 * @description Netease3
 *
 * N个职业，每个职业M个玩家。
 * 输入N，M
 * 每行代表一个职业，每行中的每个元素代表这个职业的一个玩家名字
 * 现在需要组队，每个队伍N个人，需要每个职业的都有，一个玩家只能加入一个队伍
 * 然后输入若干行
 * i j X p q   (从1算起)
 * X为Y表示第i个职业第j个玩家必须要跟第p个职业第q个玩家组队
 * X为N表示第i个职业第j个玩家必须不跟第p个职业第q个玩家组队
 *
 * 已知题目限制，只有一种可行的组队方法且没有冲突。求具体组队方法
 *
 * 输入：
 * 3 4
 * ABCD
 * efgh
 * IJKL
 * 1 1 Y 3 2
 * 1 2 N 2 2
 * 2 2 Y 3 4
 * 1 3 Y 2 3
 * 1 1 N 2 4
 * 3 1 Y 1 3
 * 0 0 N 0 0
 * 输出
 * AeJ
 * BhK
 * CgI
 * DfL
 *
 *
 * @date 2020-4-11 18:57
 */
public class NeTease3 {

    public static boolean[][] hate = new boolean[65][65];
    public static boolean[][] must = new boolean[65][65];
    public static Set<Character> set = new HashSet<>();
    public static int N, M;
    public static boolean find = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        char[][] name = new char[N][M];
        char[][] ans = new char[M][N];

        for (int i = 0; i < N; i++) {
            name[i] = sc.next().toCharArray();
            if (i > 0){
                for (int j = 0; j < name[i].length; j++) {
                    set.add(name[i][j]);
                }
            }
        }
        for (int i = 0; i < M; i++) {
            ans[i][0] = name[0][i];
        }
        String s = sc.nextLine();

        while((s = sc.nextLine()).charAt(0) != '0'){
            int i1 = s.charAt(0) - '0';
            int j1 = s.charAt(2) - '0';
            char c = s.charAt(4);
            int i2 = s.charAt(6) - '0';
            int j2 = s.charAt(8) - '0';

            if (c == 'Y'){
                must[name[i1-1][j1-1] - 'A'][name[i2-1][j2-1] - 'A'] = true;
                must[name[i2-1][j2-1] - 'A'][name[i1-1][j1-1] - 'A'] = true;
            }
            else {
                hate[name[i1-1][j1-1] - 'A'][name[i2-1][j2-1] - 'A'] = true;
                hate[name[i2-1][j2-1] - 'A'][name[i1-1][j1-1] - 'A'] = true;
            }
        }

        if (N == 1){
            for (int i = 0; i < name[0].length; i++) {
                System.out.println(name[0][i]);
            }
        }
        else {
            traceBack(name, ans, 1, 0);
        }

    }

    public static void traceBack(char[][] name, char[][] ans, int n, int m){
        if (find){
            return;
        }
        else if (m == M && n == N - 1){
            if (validate(ans)) {
                for (int i = 0; i < ans.length; i++) {
                    System.out.println(ans[i]);
                }
                find = true;
            }
        }
        else if (m == M){
            traceBack(name,ans,n+1,0);
        }
        else {
            for (int i = 0; i < M; i++) {
                if (set.contains(name[n][i])) {
                    ans[m][n] = name[n][i];
                    set.remove(name[n][i]);
                    traceBack(name, ans, n, m + 1);
                    set.add(name[n][i]);
                }
            }
        }
    }

    public static boolean validate(char[][] ans){
        for (int i = 0; i < ans.length; i++) {
            if (!groupValid(ans[i])){
                return false;
            }
        }
        return true;
    }

    public static boolean groupValid(char[] ans){

        for (int i = 0; i < ans.length; i++) {
            for (int k = 0; k < 65; k++) {
                if (must[ans[i] - 'A'][k] == true){
                    boolean m = false;
                    for (int p = 0; p < ans.length; p++) {
                        if (k == ans[p] - 'A'){
                            m = true;
                            break;
                        }
                    }
                    if (!m){
                        return false;
                    }
                }
            }

            for (int j = i + 1; j < ans.length; j++) {
                if (hate[ans[i] - 'A'][ans[j] - 'A']){
                    return false;
                }
            }
        }

        return true;

    }


}
