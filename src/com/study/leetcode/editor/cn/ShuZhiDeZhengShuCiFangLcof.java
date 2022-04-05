//<p>实现 <a href="https://www.cplusplus.com/reference/valarray/pow/">pow(<em>x</em>, <em>n</em>)</a> ，即计算 x 的 n 次幂函数（即，x<sup>n</sup>）。不得使用库函数，同时不需要考虑大数问题。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 2.00000, n = 10
//<strong>输出：</strong>1024.00000
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 2.10000, n = 3
//<strong>输出：</strong>9.26100</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 2.00000, n = -2
//<strong>输出：</strong>0.25000
//<strong>解释：</strong>2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>-100.0 < x < 100.0</code></li>
//	<li><code>-2<sup>31</sup> <= n <= 2<sup>31</sup>-1</code></li>
//	<li><code>-10<sup>4</sup> <= x<sup>n</sup> <= 10<sup>4</sup></code></li>
//</ul>
//
//<p> </p>
//
//<p>注意：本题与主站 50 题相同：<a href="https://leetcode-cn.com/problems/powx-n/">https://leetcode-cn.com/problems/powx-n/</a></p>
//<div><div>Related Topics</div><div><li>递归</li><li>数学</li></div></div><br><div><li>👍 281</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 16]数值的整数次方
 *
 * @author 秦笑笑
 * @date 2022-03-30 22:14:11
 */
public class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (x == 0) return 0;
            long b = n;
            if (b < 0) {
                x = 1 / x;
                b = -b;
            }
            double res = 1.0;
            while (b > 0) {
                // 取余数 n % 2 等价于 判断二进制最右一位值 n&1 ；
                if ((b & 1) == 1) res *= x;
                x *= x;
                b >>= 1;
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
