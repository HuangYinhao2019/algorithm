package exam.written.alibaba;/**
 * @description Alibaba8
 * @author liusandao
 * @date 2020-4-27 19:05
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-27 19:05
 */

public class Alibaba8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N;
            N = sc.nextInt();
            char[][] grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                grid[i] = sc.next().toCharArray();
            }
            int begini = 0, beginj = 0;
            int endi = 0, endj = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 'E') {
                        endi = i;
                        endj = j;
                    } else if (grid[i][j] == 'S') {
                        begini = i;
                        beginj = j;
                    } else if (grid[i][j] == '#') {
                        count++;
                    }
                }
            }
            LinkedList<int[]> path = new LinkedList<>();
            findPath(path, grid, begini, beginj, endi, endj, count);
            char[] d = pathToDirect(path);


        }
    }

    public static boolean findPath(LinkedList<int[]> path, char[][] grid, int nowi, int nowj, int endi, int endj, int count){
        if (count == 0 && nowi == endi && nowj == endj){
            path.add(new int[]{nowi,nowj});
            return true;
        }else if (nowi < 0 || nowi >= grid.length || nowj < 0 || nowj >= grid.length || grid[nowi][nowj] == '.'){
            return false;
        }else {
            path.add(new int[]{nowi,nowj});
            grid[nowi][nowj] = '.';
            count--;
            if (findPath(path,grid,nowi-1,nowj,endi,endj,count) ||
                findPath(path,grid,nowi+1,nowj,endi,endj,count) ||
                findPath(path,grid,nowi,nowj-1,endi,endj,count) ||
                findPath(path,grid,nowi,nowj+1,endi,endj,count)){
                return true;
            }
            else {
                path.pollLast();
                grid[nowi][nowj] = '#';
                count++;
                return false;
            }
        }
    }

    public static char[] pathToDirect(LinkedList<int[] > path){
        char[] d = new char[path.size() - 1];
        for (int i = 1; i < path.size(); i++) {
            int[] pre = path.get(i-1);
            int[] now = path.get(i);
            if (pre[0] - now[0] == 1){
                d[i-1] = 'd';
            }else if (now[0] - pre[0] == 1){
                d[i-1] = 'u';
            }else if (pre[1] - now[1] == 1){
                d[i-1] = 'l';
            }else if (now[1] - pre[1] == 1){
                d[i-1] = 'r';
            }
        }
        return d;
    }

}
