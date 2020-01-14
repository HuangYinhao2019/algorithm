package jian;

public class Mathamatics {
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        else if(exponent > 0){
            double ans = 1;
            while(exponent > 0){
                if (exponent % 2 == 1) ans = ans * base;
                base = base * base;
                exponent /= 2;
            }
            return ans;
        }
        else {
            exponent = -exponent;
            double ans = 1;
            while(exponent > 0){
                if (exponent % 2 == 1) ans = ans * base;
                base = base * base;
                exponent /= 2;
            }
            ans = (double)(1.00 / ans);
            return ans;
        }

    }

    public static void main(String[] args) {
        Mathamatics m = new Mathamatics();
        System.out.println(m.Power(3.33,-2));
    }
}
