package jian;

public class JumpFloorII {
    public int JumpFloorII(int target) {
        int ans = 1;
        for(int i = 1;i < target;i++){
            ans *= 2;
        }
        return ans;
    }

    public static void main(String[] args){
        JumpFloorII jumpFloor = new JumpFloorII();
        System.out.println(jumpFloor.JumpFloorII(4));
    }
}
