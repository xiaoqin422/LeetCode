package com.study.leetcode.editor.cn;
//<p>给定一个非负整数数组 <code>nums</code> 和一个整数&nbsp;<code>m</code> ，你需要将这个数组分成&nbsp;<code>m</code><em>&nbsp;</em>个非空的连续子数组。</p>
//
//<p>设计一个算法使得这&nbsp;<code>m</code><em>&nbsp;</em>个子数组各自和的最大值最小。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [7,2,5,10,8], m = 2
//<strong>输出：</strong>18
//<strong>解释：</strong>
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,2,3,4,5], m = 2
//<strong>输出：</strong>9
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,4,4], m = 3
//<strong>输出：</strong>4
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
//	<li><code>0 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
//	<li><code>1 &lt;= m &lt;= min(50, nums.length)</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>二分查找</li><li>动态规划</li></div></div><br><div><li>👍 681</li><li>👎 0</li></div>

/**
 * [410]split-array-largest-sum
 *
 * @author 秦笑笑
 * @date 2022-05-05 21:29:05
 */
public class P410_SplitArrayLargestSum {
    public static void main(String[] args) {
        Solution solution = new P410_SplitArrayLargestSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int m) {
            return shipWithinDays(nums, m);
        }

        public int shipWithinDays(int[] weights, int days) {
            // int left = 1, right = 500 + 1; 最小载重和最大载重
            int left = 0, right = 1;
            for (int weight : weights) {
                left = Math.max(left, weight);
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
