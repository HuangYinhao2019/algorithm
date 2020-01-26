package leetcode.biweeklym1d25;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solutionm1d25 {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,ArrayList> m = new HashMap<Integer, ArrayList>();
        for (int i = 0; i < arr.length; i++) {
            if (!m.containsKey(arr[i])) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                m.put(arr[i],a);
            }
            else {
                m.get(arr[i]).add(i);
            }
        }
        int[] ans = new int[arr.length];
        Arrays.sort(arr);
        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1])
                continue;
            else{
                ArrayList<Integer> a = m.get(arr[i]);
                for (Integer p:a) {
                    ans[p] = k;
                }
                k++;
            }
        }
        return ans;
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        else{
            for (int i = 0; i < palindrome.length() / 2; i++) {
                if (palindrome.charAt(i) != 'a'){
                    return palindrome.replaceFirst(palindrome.substring(i,i+1),"a");
                }
            }
            return palindrome.substring(0,palindrome.length()-1) + "b";
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length; //3
        int n = mat[0].length; //4
        if (m == 1 || n == 1)
            return mat;
        for (int i = 0; i < n - 1; i++) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                if (j < m && i + j < n)
                    a.add(mat[j][i + j]);
            }
            int[] arr = new int[a.size()];
            for (int j = 0; j < a.size(); j++) {
                arr[j] = a.get(j);
            }
            Arrays.sort(arr);
            for (int j = 0; j < m; j++) {
                if (j < m && i + j < n)
                    mat[j][i + j] = arr[j];
            }
        }
        for (int i = 1; i < m - 1; i++) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                if (i + j < m && j < n)
                    a.add(mat[i + j][j]);
            }
            int[] arr = new int[a.size()];
            for (int j = 0; j < a.size(); j++) {
                arr[j] = a.get(j);
            }
            Arrays.sort(arr);
            for (int j = 0; j < m; j++) {
                if (i + j < m && j < n)
                    mat[i + j][j] = arr[j];
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Solutionm1d25 s = new Solutionm1d25();
        int []arr = new int[]{37,12,28,9,100,56,80,5,12};
        String ss = "aaabaaa";
        System.out.println(s.breakPalindrome(ss));
        int [][]mat = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        s.diagonalSort(mat);
    }
}
