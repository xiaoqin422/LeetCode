//<p>统计一个数字在排序数组中出现的次数。</p>
//
//<p> </p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 8
//<strong>输出:</strong> 2</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 6
//<strong>输出:</strong> 0</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>0 <= nums.length <= 10<sup>5</sup></code></li>
//	<li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
//	<li><code>nums</code> 是一个非递减数组</li>
//	<li><code>-10<sup>9</sup> <= target <= 10<sup>9</sup></code></li>
//</ul>
//
//<p> </p>
//
//<p><strong>注意：</strong>本题与主站 34 题相同（仅返回值不同）：<a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/</a></p>
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 302</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.UnknownFormatConversionException;

/**
 * [剑指 Offer 53 - I]在排序数组中查找数字 I
 * @author 秦笑笑
 * @date 2022-04-23 22:14:55
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        return dfs(nums,target,0, nums.length - 1,0);
    }
    private int dfs(int[] nums, int target,int left ,int right,int sum){
        if (left > right) return sum;
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target){
            sum += 1 + dfs(nums,target,left,mid - 1,sum) + dfs(nums,target,mid + 1,right,sum);
        }else if (nums[mid] > target){
            sum += dfs(nums,target,left,mid - 1,sum);
        }else {
            sum += dfs(nums,target,mid + 1,right,sum);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
