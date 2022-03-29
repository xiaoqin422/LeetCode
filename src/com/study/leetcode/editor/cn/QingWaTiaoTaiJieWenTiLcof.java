//<p>一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 <code>n</code>&nbsp;级的台阶总共有多少种跳法。</p>
//
//<p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>n = 2
//<strong>输出：</strong>2
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>n = 7
//<strong>输出：</strong>21
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>n = 0
//<strong>输出：</strong>1</pre>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>0 &lt;= n &lt;= 100</code></li>
//</ul>
//
//<p>注意：本题与主站 70 题相同：<a href="https://leetcode-cn.com/problems/climbing-stairs/">https://leetcode-cn.com/problems/climbing-stairs/</a></p>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>记忆化搜索</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 264</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 10- II]青蛙跳台阶问题
 * @author 秦笑笑
 * @date 2022-03-28 19:37:17
 */
public class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    第1级或者第0级，只有一种
    第2级有两种
    第3级出现的和第1、2级有关：---或者 从第1级跳两步走上来 f(n-2)
                            ----或者 从第2级跳一步上来(fn-1)
     斐波那契数列
     */

    public int numWays(int n) {
        int[] dep = new int[Math.max(n + 1,3)];
        dep[0] = 1;
        dep[1] = 1;
        dep[2] = 2;
        for (int i = 3; i <= n; i++) {
            dep[i] = (dep[i - 1] + dep[i - 2]) % 1000000007;
        }
        return dep[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
