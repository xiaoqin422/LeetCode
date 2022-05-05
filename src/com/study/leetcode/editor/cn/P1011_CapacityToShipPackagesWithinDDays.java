package com.study.leetcode.editor.cn;
//<p>传送带上的包裹必须在 <code>days</code> 天内从一个港口运送到另一个港口。</p>
//
//<p>传送带上的第 <code>i</code>&nbsp;个包裹的重量为&nbsp;<code>weights[i]</code>。每一天，我们都会按给出重量（<code>weights</code>）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。</p>
//
//<p>返回能在 <code>days</code> 天内将传送带上的所有包裹送达的船的最低运载能力。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//<strong>输出：</strong>15
//<strong>解释：</strong>
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10
//
//请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。 
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>weights = [3,2,2,4,1,4], days = 3
//<strong>输出：</strong>6
//<strong>解释：</strong>
//船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
//第 1 天：3, 2
//第 2 天：2, 4
//第 3 天：1, 4
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>weights = [1,2,3,1,1], days = 4
//<strong>输出：</strong>3
//<strong>解释：</strong>
//第 1 天：1
//第 2 天：2
//第 3 天：3
//第 4 天：1, 1
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= days &lt;= weights.length &lt;= 5 * 10<sup>4</sup></code></li>
//	<li><code>1 &lt;= weights[i] &lt;= 500</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 463</li><li>👎 0</li></div>

/**
 * [1011]capacity-to-ship-packages-within-d-days
 *
 * @author 秦笑笑
 * @date 2022-05-05 21:10:56
 */
public class P1011_CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Solution solution = new P1011_CapacityToShipPackagesWithinDDays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            // int left = 1, right = 500 + 1; 最小载重和最大载重
            int left = 0, right = 1;
            for (int weight : weights) {
                left = Math.max(left,weight);
                right += weight;
            }
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (f(weights, mid) <= days) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        /**
         * 二分的单调函数 （x的运载能力，求天数） 单调递减！！！
         *
         * @param weights 用于计算函数值
         * @param x       参数x
         * @return 需要的天数
         */
        private int f(int[] weights, int x) {
            int days = 0;
            for (int i = 0; i < weights.length; ) {
                // 船只的承重范围
                int cap = x;
                while (i < weights.length) {
                    // 尽可能承重多一点
                    if (cap < weights[i]) break;
                    else cap -= weights[i];
                    i++;
                }
                days++;
            }
            return days;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
