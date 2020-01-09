package jian;

public class JumpFloor {
    public int JumpFloor(int n) {
        if(n == 1){
            return 1;
        }
        else if(n == 2){
            return 2;
        }
        int a = 1,b = 1,c = 2;
        for(int i = 3;i <= n;i++){
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    public static void main(String[] args){
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.JumpFloor(4));
    }
}
