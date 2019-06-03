package maxprofit_III;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * User:Mr.Du
 * Date:2019-06-03
 * Time:20:53
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {2,4,6,1,3,8,3};
        System.out.println(getTwoTradeMax(arr));
    }

    //最大进行两次交易获取的最大利润
    //思想：我们可以对数组进行划分，求前半部分最大值max1和后半部分最大值max2，max1+max2就是获取的最大利润

    public static int getTwoTradeMax(int[] arr){
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max,getTradeMax(arr,0,i)+getTradeMax(arr,i,arr.length));
        }

        return max;
    }

    //返回只交易一次的最大利润
    public static int getTradeMax(int[] arr,int start,int end){
        int min = arr[start];
        int max = 0;
        for(int i = start;i<end;i++){
            max = Math.max(max,arr[i]-min);
            min = Math.min(arr[i],min);
        }
        return max;
    }
}
