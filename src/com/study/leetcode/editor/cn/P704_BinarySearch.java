package com.study.leetcode.editor.cn;
//<p>给定一个&nbsp;<code>n</code>&nbsp;个元素有序的（升序）整型数组&nbsp;<code>nums</code> 和一个目标值&nbsp;<code>target</code> &nbsp;，写一个函数搜索&nbsp;<code>nums</code>&nbsp;中的 <code>target</code>，如果目标值存在返回下标，否则返回 <code>-1</code>。</p>
//
//<p><br>
//<strong>示例 1:</strong></p>
//
//<pre><strong>输入:</strong> <code>nums</code> = [-1,0,3,5,9,12], <code>target</code> = 9
//<strong>输出:</strong> 4
//<strong>解释:</strong> 9 出现在 <code>nums</code> 中并且下标为 4
//</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre><strong>输入:</strong> <code>nums</code> = [-1,0,3,5,9,12], <code>target</code> = 2
//<strong>输出:</strong> -1
//<strong>解释:</strong> 2 不存在 <code>nums</code> 中因此返回 -1
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li>你可以假设 <code>nums</code>&nbsp;中的所有元素是不重复的。</li>
//	<li><code>n</code>&nbsp;将在&nbsp;<code>[1, 10000]</code>之间。</li>
//	<li><code>nums</code>&nbsp;的每个元素都将在&nbsp;<code>[-9999, 9999]</code>之间。</li>
//</ol>
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 793</li><li>👎 0</li></div>

/**
 * [704]binary-search
 * @author 秦笑笑
 * @date 2022-05-04 09:44:17
 */
public class P704_BinarySearch {
    public static void main(String[] args) {
        Solution solution = new P704_BinarySearch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search1(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
        public int search(int[] nums, int target) {
            int left = 0,right = nums.length;
            while (left < right){
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target){
                    return mid;
                }else if (nums[mid] < target){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            return -1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
