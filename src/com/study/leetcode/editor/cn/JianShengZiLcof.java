//<p>给你一根长度为 <code>n</code> 的绳子，请把绳子剪成整数长度的 <code>m</code> 段（m、n都是整数，n&gt;1并且m&gt;1），每段绳子的长度记为 <code>k[0],k[1]...k[m-1]</code> 。请问 <code>k[0]*k[1]*...*k[m-1]</code> 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。</p>
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
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>2 &lt;= n &lt;= 58</code></li>
//</ul>
//
//<p>注意：本题与主站 343 题相同：<a href="https://leetcode-cn.com/problems/integer-break/">https://leetcode-cn.com/problems/integer-break/</a></p>
//<div><div>Related Topics</div><div><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 398</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 14- I]剪绳子
 *
 * @author 秦笑笑
 * @date 2022-03-29 22:44:43
 */
public class JianShengZiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
        solution.cuttingRope(8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope1(int n) {
            int max = n - 1;
            for (int i = 2; i <= n; i++) {//分段个数 【2，n】
                int len = n / i; //每段的基础长度
                int to = n % i;
                int num = (int) Math.pow(len, i - to);
                if (to != 0) {
                    num *= Math.pow(len + 1, to);
                }
                max = Math.max(num, max);
            }
            return max;
        }
        // 数学公式推导，尽量分为长度为3的为最优
        public int cuttingRope(int n) {
            if (n <= 3) return n -1; //必须分段
            if (n % 3 == 0) return (int) Math.pow(3,n / 3);//被3整除，不考虑余数
            // 余数为1 3的 n/3-1 次方乘上 4
            if (n % 3 == 1) return (int) (Math.pow(3,(n / 3 - 1)) * 4);
            // 余数为2 3的 n/3 次方乘上 2
            return (int) Math.pow(3,n / 3) * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
