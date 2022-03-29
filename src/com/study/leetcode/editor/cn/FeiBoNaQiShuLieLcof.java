//<p>写一个函数，输入 <code>n</code> ，求斐波那契（Fibonacci）数列的第 <code>n</code> 项（即 <code>F(N)</code>）。斐波那契数列的定义如下：</p>
//
//<pre>
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.</pre>
//
//<p>斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。</p>
//
//<p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 2
//<strong>输出：</strong>1
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 5
//<strong>输出：</strong>5
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>0 <= n <= 100</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>记忆化搜索</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 327</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.HashMap;

/**
 * [剑指 Offer 10- I]斐波那契数列
 *
 * @author 秦笑笑
 * @date 2022-03-28 19:12:07
 */
public class FeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int fib(int n) {
            int a = 0, b = 1, sum = 0;
            for (int i = 0; i < n; i++) {
                // 数组第i项
                sum = (a + b) % 1000000007;
                a = b;
                b = sum;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
