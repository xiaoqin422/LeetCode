package com.study.leetcode.editor.cn;
//<p>给你一个整数数组 <code>nums</code><em> </em>，按要求返回一个新数组&nbsp;<code>counts</code><em> </em>。数组 <code>counts</code> 有该性质： <code>counts[i]</code> 的值是&nbsp; <code>nums[i]</code> 右侧小于&nbsp;<code>nums[i]</code> 的元素的数量。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [5,2,6,1]
//<strong>输出：</strong><code>[2,1,1,0] 
//<strong>解释：</strong></code>
//5 的右侧有 <strong>2 </strong>个更小的元素 (2 和 1)
//2 的右侧仅有 <strong>1 </strong>个更小的元素 (1)
//6 的右侧有 <strong>1 </strong>个更小的元素 (1)
//1 的右侧有 <strong>0 </strong>个更小的元素
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1]
//<strong>输出：</strong>[0]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1,-1]
//<strong>输出：</strong>[0,0]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树状数组</li><li>线段树</li><li>数组</li><li>二分查找</li><li>分治</li><li>有序集合</li><li>归并排序</li></div></div><br><div><li>👍 813</li><li>👎 0</li></div>

import java.util.*;

/**
 * [315]count-of-smaller-numbers-after-self
 *
 * @author 秦笑笑
 * @date 2022-05-20 16:08:45
 */
public class P315_CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new P315_CountOfSmallerNumbersAfterSelf().new Solution();
        solution.countSmaller(new int[]{1,9,7,8,5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Pair {
            int val, id;
            Pair(int val, int id) {
                // 记录数组的元素值
                this.val = val;
                // 记录元素在数组中的原始索引
                this.id = id;
            }
        }

        // 归并排序所用的辅助数组
        private Pair[] temp;
        // 记录每个元素后面比自己小的元素个数
        private int[] count;

        // 主函数
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            count = new int[n];
            temp = new Pair[n];
            Pair[] arr = new Pair[n];
            // 记录元素原始的索引位置，以便在 count 数组中更新结果
            for (int i = 0; i < n; i++)
                arr[i] = new Pair(nums[i], i);

            // 执行归并排序，本题结果被记录在 count 数组中
            sort(arr, 0, n - 1);

            List<Integer> res = new LinkedList<>();
            for (int c : count) res.add(c);
            return res;
        }

        // 归并排序
        private void sort(Pair[] arr, int lo, int hi) {
            if (lo == hi) return;
            int mid = lo + (hi - lo) / 2;
            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }

        // 合并两个有序数组
        private void merge(Pair[] arr, int lo, int mid, int hi) {
            for (int i = lo; i <= hi; i++) {
                temp[i] = arr[i];
            }

            int i = lo, j = mid + 1;
            for (int p = lo; p <= hi; p++) {
                if (i == mid + 1) {
                    arr[p] = temp[j++];
                } else if (j == hi + 1) {
                    arr[p] = temp[i++];
                    // 更新 count 数组
                    count[arr[p].id] += j - mid - 1;
                } else if (temp[i].val > temp[j].val) {
                    arr[p] = temp[j++];
                } else {
                    arr[p] = temp[i++];
                    // 更新 count 数组
                    count[arr[p].id] += j - mid - 1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
