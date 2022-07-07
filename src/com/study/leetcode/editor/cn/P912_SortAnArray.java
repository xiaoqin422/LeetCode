package com.study.leetcode.editor.cn;
//<p>给你一个整数数组&nbsp;<code>nums</code>，请你将该数组升序排列。</p>
//
//<p>&nbsp;</p>
//
//<ol>
//</ol>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [5,2,3,1]
//<strong>输出：</strong>[1,2,3,5]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [5,1,1,2,0,0]
//<strong>输出：</strong>[0,0,1,1,2,5]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
//	<li><code>-5 * 10<sup>4</sup> &lt;= nums[i] &lt;= 5 * 10<sup>4</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>桶排序</li><li>计数排序</li><li>基数排序</li><li>排序</li><li>堆（优先队列）</li><li>归并排序</li></div></div><br><div><li>👍 569</li><li>👎 0</li></div>

/**
 * [912]sort-an-array
 *
 * @author 秦笑笑
 * @date 2022-05-20 09:59:56
 */
public class P912_SortAnArray {
    public static void main(String[] args) {
        Solution solution = new P912_SortAnArray().new Solution();
        solution.sortArray(new int[]{5,2,3,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 用于合并两个数组的辅助数组
        int[] temp;

        public int[] sortArray(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        public void sort(int[] nums, int start, int end) {
            // 单个元素不需要排序
            if (start == end) return;
            int mid = start + ((end - start) >> 1);
            // 递归处理左数组
            sort(nums, start, mid);
            // 递归处理右数组
            sort(nums, mid + 1, end);
            // 进行原地合并数组
            marge(nums, start, mid, end);
        }

        private void marge(int[] nums, int lo, int m, int lr) {
            for (int i = lo; i <= lr; i++) {
                temp[i] = nums[i];
            }
            int p = lo, q = m + 1;
            // 双指针合并有序数组
            for (int i = lo; i <= lr; i++) {
                if (p == m + 1) {
                    // 左边已经遍历结束
                    nums[i] = temp[q++];
                } else if (q == lr + 1) { // 注意是lr + 1
                    // 右边已经遍历结束
                    nums[i] = temp[p++];
                } else if (temp[p] <= temp[q]) {
                    // 左边进入
                    nums[i] = temp[p++];
                } else if (temp[p] > temp[q]){
                    nums[i] = temp[q++];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
