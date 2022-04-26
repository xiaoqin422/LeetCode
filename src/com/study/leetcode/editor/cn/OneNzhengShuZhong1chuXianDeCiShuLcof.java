//<p>输入一个整数 <code>n</code> ，求1～n这n个整数的十进制表示中1出现的次数。</p>
//
//<p>例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 12
//<strong>输出：</strong>5
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 13
//<strong>输出：</strong>6</pre>
//
//<p> </p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>1 <= n < 2^31</code></li>
//</ul>
//
//<p>注意：本题与主站 233 题相同：<a href="https://leetcode-cn.com/problems/number-of-digit-one/">https://leetcode-cn.com/problems/number-of-digit-one/</a></p>
//<div><div>Related Topics</div><div><li>递归</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 317</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 43]1～n 整数中 1 出现的次数
 *
 * @author 秦笑笑
 * @date 2022-04-20 16:10:47
 */
public class OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
        System.out.println(solution.countDigitOne(20));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int target = 0;

        public int countDigitOne(int n) {
            this.target = n;
            return dfs(n, 0, 0);
        }

        private int dfs(int n, int sum, int index) {
            if (n == 0) return sum;
            int cur = n % 10;
            int digit = (int) Math.pow(10, index);
            int high = n / 10;
            int low = target % digit;
            if (cur == 0) {
                sum += high * digit;
            } else if (cur == 1) {
                sum += high * digit + 1 + low;
            } else {
                sum += (high + 1) * digit ;
            }
            return dfs(n / 10, sum, index + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
