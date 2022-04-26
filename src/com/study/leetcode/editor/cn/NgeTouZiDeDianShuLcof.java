//<p>把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。</p>
//
//<p>&nbsp;</p>
//
//<p>你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre><strong>输入:</strong> 1
//<strong>输出:</strong> [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
//</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre><strong>输入:</strong> 2
//<strong>输出:</strong> [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>1 &lt;= n &lt;= 11</code></p>
//<div><div>Related Topics</div><div><li>数学</li><li>动态规划</li><li>概率与统计</li></div></div><br><div><li>👍 405</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [剑指 Offer 60]n个骰子的点数
 *
 * @author 秦笑笑
 * @date 2022-04-17 23:02:28
 */
public class NgeTouZiDeDianShuLcof {
    public static void main(String[] args) {
        Solution solution = new NgeTouZiDeDianShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] dicesProbability(int n) {
            double[] dp = new double[6];
            Arrays.fill(dp, 1.0 / 6.0);
            for (int i = 2; i <= n; i++) {
                double[] res = new double[5 * i + 1];
                for (int j = 0; j < dp.length; j++) {
                    for (int k = 0; k < 6; k++) {
                        res[j + k] += dp[j] / 6.0;
                    }
                }
                dp = res;
            }
            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
