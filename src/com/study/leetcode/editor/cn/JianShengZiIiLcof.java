//<p>给你一根长度为 <code>n</code> 的绳子，请把绳子剪成整数长度的 <code>m</code>&nbsp;段（m、n都是整数，n&gt;1并且m&gt;1），每段绳子的长度记为 <code>k[0],k[1]...k[m - 1]</code> 。请问 <code>k[0]*k[1]*...*k[m - 1]</code> 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。</p>
//
//<p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入: </strong>2
//<strong>输出: </strong>1
//<strong>解释: </strong>2 = 1 + 1, 1 &times; 1 = 1</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre><strong>输入: </strong>10
//<strong>输出: </strong>36
//<strong>解释: </strong>10 = 3 + 3 + 4, 3 &times;&nbsp;3 &times;&nbsp;4 = 36</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>2 &lt;= n &lt;= 1000</code></li>
//</ul>
//
//<p>注意：本题与主站 343 题相同：<a href="https://leetcode-cn.com/problems/integer-break/">https://leetcode-cn.com/problems/integer-break/</a></p>
//<div><div>Related Topics</div><div><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 179</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 14- II]剪绳子 II
 *
 * @author 秦笑笑
 * @date 2022-04-03 15:08:30
 */
public class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            if (n <= 3) return n - 1;
            long res = 1L;
            int p = (int) 1e9 + 7;
            //贪心算法，优先切三，其次切二
            while (n > 4) {
                res = res * 3 % p;
                n -= 3;
            }
            //出来循环只有三种情况，分别是n=2、3、4
            return (int) (res * n % p);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
