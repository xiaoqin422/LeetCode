package com.study.leetcode.editor.cn;
//<p>给定两个大小分别为 <code>m</code> 和 <code>n</code> 的正序（从小到大）数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>。请你找出并返回这两个正序数组的 <strong>中位数</strong> 。</p>
//
//<p>算法的时间复杂度应该为 <code>O(log (m+n))</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [1,3], nums2 = [2]
//<strong>输出：</strong>2.00000
//<strong>解释：</strong>合并数组 = [1,2,3] ，中位数 2
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [1,2], nums2 = [3,4]
//<strong>输出：</strong>2.50000
//<strong>解释：</strong>合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//</pre>
//
//<p>&nbsp;</p>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>nums1.length == m</code></li>
//	<li><code>nums2.length == n</code></li>
//	<li><code>0 &lt;= m &lt;= 1000</code></li>
//	<li><code>0 &lt;= n &lt;= 1000</code></li>
//	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
//	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治</li></div></div><br><div><li>👍 5396</li><li>👎 0</li></div>

/**
 * [4]median-of-two-sorted-arrays
 *
 * @author 秦笑笑
 * @date 2022-05-02 20:34:57
 */
public class P004_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P004_MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int index1 = 0, index2 = 0;
            int count = 0;
            int mid = (nums1.length + nums2.length) / 2 + 1; //中位数下标的下一位
            int p = 0, q = 0;
            while (index1 < nums1.length && index2 < nums2.length && count < mid) {
                int n = nums1[index1];
                int m = nums2[index2];
                if (n <= m) {
                    index1++;
                } else {
                    index2++;
                }
                p = q;
                q = Math.min(n, m);
                count++;
            }
            while (count < mid && index1 < nums1.length){
                p = q;
                q = nums1[index1 ++];
                count++;
            }
            while (count < mid && index2 < nums2.length){
                p = q;
                q = nums2[index2 ++];
                count++;
            }
            return (nums1.length + nums2.length) % 2 == 0 ? (p + q) / 2.0 : q;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
