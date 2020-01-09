package jian;

public class Find {
    public boolean Find(int target, int [][] array) {
        int r = array.length;
        int c = array[0].length;
        int i = 0,j = c - 1;
        while(i < r && j >= 0){
            if(array[i][j] > target)
                j--;
            else if(array[i][j] < target)
                i++;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        Find find = new Find();
    }
}
