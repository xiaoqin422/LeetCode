//<p>输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。</p>
//
//<p>要求时间复杂度为O(n)。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例1:</strong></p>
//
//<pre><strong>输入:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
//<strong>输出:</strong> 6
//<strong>解释:</strong>&nbsp;连续子数组&nbsp;[4,-1,2,1] 的和最大，为&nbsp;6。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;=&nbsp;arr.length &lt;= 10^5</code></li>
//	<li><code>-100 &lt;= arr[i] &lt;= 100</code></li>
//</ul>
//
//<p>注意：本题与主站 53 题相同：<a href="https://leetcode-cn.com/problems/maximum-subarray/">https://leetcode-cn.com/problems/maximum-subarray/</a></p>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>动态规划</li></div></div><br><div><li>👍 513</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 42]连续子数组的最大和
 *
 * @author 秦笑笑
 * @date 2022-04-20 15:38:53
 */
public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            //f(i) =  max[f(i-1)+f(i),f(i)]  保存f(i)
            int max = nums[0];
            int sum = 0;
            for (int item : nums) {
                if (sum < 0 && item > sum) {
                    // 如果该项大于之前子项之和,且子项之和小于0 则从该项开始重新开始子序列
                    sum = item;
                } else {
                    sum += item;
                }
                max = Math.max(sum, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
