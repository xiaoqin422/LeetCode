//<p>输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums =&nbsp;[1,2,3,4]
//<strong>输出：</strong>[1,3,2,4] 
//<strong>注：</strong>[3,1,2,4] 也是正确的答案之一。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li><code>0 &lt;= nums.length &lt;= 50000</code></li>
//	<li><code>0 &lt;= nums[i] &lt;= 10000</code></li>
//</ol>
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 214</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.time.OffsetDateTime;

/**
 * [剑指 Offer 21]调整数组顺序使奇数位于偶数前面
 * @author 秦笑笑
 * @date 2022-04-04 16:10:51
 */
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            while (start < end && nums[start] % 2 != 0){
                start ++;
            }
            while (start < end && nums[end] % 2 == 0){
                end--;
            }
            if (start < end){
                int temp = nums[start];
                nums[start ++] = nums[end];
                nums[end --] = temp;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
