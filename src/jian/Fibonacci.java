package jian;

public class Fibonacci {
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int a = 0,b = 1,c = 1;
        for(int i = 3;i <= n;i++){
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(3));
    }
}


