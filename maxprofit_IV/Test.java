package maxprofit_IV;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * User:Mr.Du
 * Date:2019-06-03
 * Time:21:47
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {2,5,4,1,2,5,4,1,2,3,5,9};
        System.out.println(maxProfit(arr,2));
    }

    public static int maxProfit(int[] prices, int fee) {
        //买入时的利润
        int buy = -prices[0];
        //卖出时的利润
        int sell = 0;
        for(int i = 1;i<prices.length;i++){
            //当前买入时的利润等于之前买入的利润与之前卖出时的利润减去当前股票价的最大值
            buy = Math.max(buy,sell-prices[i]);
            sell = Math.max(buy+prices[i]-fee,sell);
        }
        return sell;
    }
}
