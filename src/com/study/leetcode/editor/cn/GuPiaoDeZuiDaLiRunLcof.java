//<p>假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre><strong>输入:</strong> [7,1,5,3,6,4]
//<strong>输出:</strong> 5
//<strong>解释: </strong>在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre><strong>输入:</strong> [7,6,4,3,1]
//<strong>输出:</strong> 0
//<strong>解释: </strong>在这种情况下, 没有交易完成, 所以最大利润为 0。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= 数组长度 &lt;= 10^5</code></p>
//
//<p>&nbsp;</p>
//
//<p><strong>注意：</strong>本题与主站 121 题相同：<a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/</a></p>
//<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 242</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 63]股票的最大利润
 * @author 秦笑笑
 * @date 2022-04-26 00:53:54
 */
public class GuPiaoDeZuiDaLiRunLcof {
    public static void main(String[] args) {
        Solution solution = new GuPiaoDeZuiDaLiRunLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxPrice = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i],min);
            maxPrice = Math.max(prices[i] - min,maxPrice);
        }
        return maxPrice;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
