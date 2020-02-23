package leetcode.weekly.weeklym2d23;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class weeklym2d23 {

    public int daysBetweenDates(String date1, String date2) {
        if (date1.equals(date2)) return 0;
        int year1 = Integer.valueOf(date1.substring(0,4));
        int year2 = Integer.valueOf(date2.substring(0,4));
        if (year1 == year2)
            if (dayOfYear(date1) >= dayOfYear(date2))
                return dayOfYear(date1) - dayOfYear(date2);
            else
                return dayOfYear(date2) - dayOfYear(date1);
        int ans = 0;
        if (year1 < year2) {
            for (int year = year1; year < year2; year++)
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
                    ans += 366;
                else
                    ans += 365;
            ans += dayOfYear(date2);
            ans -= dayOfYear(date1);
        }
        if (year2 < year1){
            for (int year = year2; year < year1; year++)
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
                    ans += 366;
                else
                    ans += 365;
            ans += dayOfYear(date1);
            ans -= dayOfYear(date2);
        }
        return ans;
    }

    public int dayOfYear(String date) {
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");

        int day = Integer.parseInt(split[2]);

        int month = Integer.parseInt(split[1]);

        if (isLeapYear(split[0]) && month > 2) {
            day += 1;
        }
        for (int i = 0; i < month - 1; i++) {
            day += arr[i];
        }
        return day;

    }

    private boolean isLeapYear(String stringYear) {
        int year = Integer.parseInt(stringYear);
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] a = new int[n];
        int edge = 0;
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1){
                a[leftChild[i]]++;
                edge++;
                if (a[leftChild[i]] > 1)
                    return false;
            }
            if (rightChild[i] != -1) {
                a[rightChild[i]]++;
                edge++;
                if (a[rightChild[i]] > 1)
                    return false;
            }
        }
        if (edge != n-1)
            return false;
        return true;
    }

    public int[] closestDivisors(int num) {
        int a = num + 1, b = num + 2;
        int[] ans = new int[2];
        int amax = 1;
        for (int i = 1; i <= (int) Math.sqrt(a); i++) {
            if (a % i == 0)
                amax = i;
        }
        int bmax = 1;
        for (int i = 1; i <= (int) Math.sqrt(b); i++) {
            if (b % i == 0)
                bmax = i;
        }
        int s1 = Math.abs((a / amax) - amax);
        int s2 = Math.abs((b / bmax) - bmax);
        if (s1 < s2){
            ans[0] = amax;
            ans[1] = a / amax;
        }
        else{
            ans[0] = bmax;
            ans[1] = b / bmax;
        }
        return ans;
    }

    public String largestMultipleOfThree(int[] digits) {
        int[][] a = new int[3][digits.length];
        int b1 = 0,b2 = 0;
        int k1 = 0,k2 = 0;
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < digits.length; i++) {
            a[0][i] = -1;
            a[1][i] = -1;
            a[2][i] = -1;
        }
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 3 == 0)
                l.add(digits[i]);
            a[digits[i] % 3][i] = digits[i];
            if (digits[i] % 3 == 1)
                b1++;
            if (digits[i] % 3 == 2)
                b2++;
        }
        Arrays.sort(a[1]);
        Arrays.sort(a[2]);
        if (b1 % 3 == b2 % 3){
            k1 = b1;
            k2 = b2;
        }
        else if (b1 == 0 && b2 != 0){
            k1 = 0;
            k2 = b2 - (b2 % 3);
        }
        else if (b2 == 0 && b1 != 0){
            k2 = 0;
            k1 = b1 - (b1 % 3);
        }
        else if ((b1 % 3 == 2 && b2 % 3 == 1) || (b1 % 3 == 1 && b2 % 3 == 0) || (b1 % 3 == 0 && b2 % 3 == 2)){
            k1 = b1 - 1;
            k2 = b2;
        }
        else if ((b2 % 3 == 2 && b1 % 3 == 1) || (b2 % 3 == 1 && b1 % 3 == 0) || (b2 % 3 == 0 && b1 % 3 == 2)){
            k1 = b1;
            k2 = b2 - 1;
        }
        for (int i = 0; i < k1; i++) {
            l.add(a[1][a[1].length-1-i]);
        }
        for (int i = 0; i < k2; i++) {
            l.add(a[2][a[2].length-1-i]);
        }
        if (l.size() == 0) return "";
        int[] an = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            an[i] = l.get(i);
        }
        Arrays.sort(an);
        if (an[an.length-1] == 0) return "0";
        String ans = "";
        for (int i = 0; i < an.length; i++) {
            ans += String.valueOf(an[an.length-1-i]);
        }
        return ans;

    }

    public static void main(String[] args) {

    }

}
