package leetcodeinterview;

public class Problem4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int r = matrix.length;
        if(r==0)
            return false;
        int c = matrix[0].length;
        int i = 0,j = c - 1;
        while(i < r && j >= 0){
            if(matrix[i][j] > target)
                j--;
            else if(matrix[i][j] < target)
                i++;
            else
                return true;
        }
        return false;
    }
}
