package leetcode.biweekly.biweeklym6d13;/**
 * @description SubrectangleQueries
 * @author liusandao
 * @date 2020-6-13 22:33
 */

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-06-13 22:33
 */

public class SubrectangleQueries {

    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                this.rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }

}
