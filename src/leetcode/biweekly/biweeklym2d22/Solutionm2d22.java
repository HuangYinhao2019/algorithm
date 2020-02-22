package leetcode.biweekly.biweeklym2d22;

import java.util.Arrays;
import java.util.HashMap;

public class Solutionm2d22 {
    private int n;
    private int discount;
    private int[] products;
    private int[] price;
    private int count;
    private HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

    public int[] sortByBits(int[] arr) {
        int[] ans = new int[arr.length];
        int[][] a = new int[15][arr.length];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < arr.length; j++) {
                a[i][j] = 100000;
            }
        }
        int[] count = new int[15];
        for (int i = 0; i < arr.length; i++) {
            int n = 0;
            int k = arr[i];
            while (k != 0){
                if (k % 2 == 1)
                    n++;
                k /= 2;
            }
            a[n][count[n]++] = arr[i];
        }
        int t = 0;
        for (int i = 0; i < 15; i++) {
            Arrays.sort(a[i]);
            for (int j = 0; j < count[i]; j++) {
                ans[t++] = a[i][j];
            }
        }
        return ans;
    }

    public void Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = products;
        this.price = price;
        this.count = 1;
        for (int i = 0; i < products.length; i++) {
            this.map.put(products[i],prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        double money = 0;
        for (int i = 0; i < product.length; i++) {
            money += (double)amount[i] * (double)this.map.get(product[i]);
        }
        if (count % n == 0){
            money = money - (money * (double)discount) / (double)100;
        }
        count++;
        return money;
    }

    public int numberOfSubstrings(String s) {
        int[] a = new int[3];
        int i = 0,j = 0;
        int ans = 0;
        while (j < s.length() && i <= j || (a[0] > 0 && a[1] > 0 && a[2] > 0)){
            if (a[0] < 1 || a[1] < 1 || a[2] < 1)
                a[s.charAt(j++) - 'a']++;
            else {
                while(a[0] > 0 && a[1] > 0 && a[2] > 0){
                    ans += s.length() - j + 1;
                    a[s.charAt(i++) - 'a']--;
                }
            }
        }
        return ans;
    }

    public int countOrders(int n) {
        if (n == 1) return 1;
        else {
            int k = n * 2;
            int sum = 0;
            for (int i = 1; i < k; i++) {
                sum += i;
            }
            return (int)(((long)sum * (long)countOrders(n-1)) % 1000000007);
        }
    }

    public static void main(String[] args) {
        Solutionm2d22 s = new Solutionm2d22();
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(s.sortByBits(arr));
    }

}
