package com.study.leetcode.editor.cn;
//<p>给你一个整数数组 <code>nums</code> 和一个整数&nbsp;<code>k</code> ，请你统计并返回 <em>该数组中和为&nbsp;<code>k</code><strong>&nbsp;</strong>的子数组的个数&nbsp;</em>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,1,1], k = 2
//<strong>输出：</strong>2
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,2,3], k = 3
//<strong>输出：</strong>2
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
//	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
//	<li><code>-10<sup>7</sup> &lt;= k &lt;= 10<sup>7</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><br><div><li>👍 1453</li><li>👎 0</li></div>

import java.util.HashMap;

/**
 * [560]subarray-sum-equals-k
 * @author 秦笑笑
 * @date 2022-04-28 16:50:44
 */
public class P560_SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new P560_SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    优化---hashMap存储
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        HashMap<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int ans = 0,sum0_i = 0;
        for (int i = 0; i < len; i++) {
            // 该项对应的前缀和
            sum0_i += nums[i];
            // 这是我们想找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
            // 如果前面有这个前缀和，则直接更新答案
            if (preSum.containsKey(sum0_j))
                ans += preSum.get(sum0_j);
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i,
                    preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;
    }
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        // 前缀和数组
        int[] h = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            h[i] = h[i - 1] + nums[i - 1];
        }
        int ans = 0;
        // 遍历前缀和数组
        for (int i = 1; i <= len; i++) {
            // 遍历数组，【j - i】 看区间有几个满足条件
            for (int j = 0; j < i; j++) {
                if (h[i] - h[j] == k)
                    ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
