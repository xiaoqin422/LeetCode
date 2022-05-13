package com.study.leetcode.editor.cn;
//<p>给定一个循环数组&nbsp;<code>nums</code>&nbsp;（&nbsp;<code>nums[nums.length - 1]</code>&nbsp;的下一个元素是&nbsp;<code>nums[0]</code>&nbsp;），返回&nbsp;<em><code>nums</code>&nbsp;中每个元素的 <strong>下一个更大元素</strong></em> 。</p>
//
//<p>数字 <code>x</code>&nbsp;的 <strong>下一个更大的元素</strong> 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 <code>-1</code>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [1,2,1]
//<strong>输出:</strong> [2,-1,2]
//<strong>解释:</strong> 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [1,2,3,4,3]
//<strong>输出:</strong> [2,3,4,-1,4]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>单调栈</li></div></div><br><div><li>👍 619</li><li>👎 0</li></div>

import java.util.*;

/**
 * [503]next-greater-element-ii
 * @author 秦笑笑
 * @date 2022-05-13 16:38:35
 */
public class P503_NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new P503_NextGreaterElementIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int[] ans = new int[len];
        // 建立全文单调栈
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[nums.length - 1]){
                if (stack.isEmpty() || stack.peek() < nums[i]){
                    stack.offer(nums[i]);
                }
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            int cur = nums[i];
            while (!stack.isEmpty() && stack.peek() <= cur){
                stack.poll();
            }
            ans[i] = stack.isEmpty()?-1:stack.peek();
            stack.offerFirst(cur);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
