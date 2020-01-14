package jian;

public class BiNary {
    public int NumberOf1(int n) {
        if(n >= 0){
            int ans = 0;
            while(n > 0){
                ans += (n % 2);
                n /= 2;
            }
            return ans;
        }
        else{
            int ans = 32;
            n += 1;
            n = Math.abs(n);
            while(n > 0){
                ans -= (n % 2);
                n /= 2;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        BiNary b = new BiNary();
        System.out.println(b.NumberOf1(Integer.MAX_VALUE));
    }
}
