package leetcode.weekly.weeklym6d07;/**
 * @description BrowserHistory
 * @author liusandao
 * @date 2020-6-7 10:38
 */

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-06-07 10:38
 */

public class BrowserHistory {

    private String homepage;
    private String[] histroy;
    private int maxNumber;
    private int currentNumber;

    public BrowserHistory(String homepage) {
        this.homepage = homepage;
        this.histroy = new String[6000];
        this.histroy[0] = homepage;
        this.maxNumber = 0;
        this.currentNumber = 0;
    }

    public void visit(String url) {
        currentNumber++;
        maxNumber = currentNumber;
        histroy[currentNumber] = url;
    }

    public String back(int steps) {
        if (steps > currentNumber){
            currentNumber = 0;
            return histroy[currentNumber];
        } else {
            currentNumber = currentNumber - steps;
            return histroy[currentNumber];
        }
    }

    public String forward(int steps) {
        if (steps > maxNumber - currentNumber){
            currentNumber = maxNumber;
            return histroy[currentNumber];
        } else {
            currentNumber = currentNumber + steps;
            return histroy[currentNumber];
        }
    }

}
