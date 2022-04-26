//<p>一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre><strong>输入:</strong> [0,1,3]
//<strong>输出:</strong> 2
//</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre><strong>输入:</strong> [0,1,2,3,4,5,6,7,9]
//<strong>输出:</strong> 8</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>1 &lt;= 数组长度 &lt;= 10000</code></p>
//<div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>哈希表</li><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 261</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 53 - II]0～n-1中缺失的数字
 * @author 秦笑笑
 * @date 2022-04-23 22:29:44
 */
public class QueShiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new QueShiDeShuZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }
    private int binarySearch(int[] nums,int left,int right){
        // 退出条件，right回退到left之前，此时的left为结果
        if (left > right) return left;
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == mid){
            return binarySearch(nums,mid + 1,right);
        }else {
            return binarySearch(nums,left,mid - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
