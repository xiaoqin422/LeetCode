package com.study.leetcode.editor.cn;
//<p>给定一个数组&nbsp;<code>nums</code>&nbsp;，如果&nbsp;<code>i &lt; j</code>&nbsp;且&nbsp;<code>nums[i] &gt; 2*nums[j]</code>&nbsp;我们就将&nbsp;<code>(i, j)</code>&nbsp;称作一个<strong><em>重要翻转对</em></strong>。</p>
//
//<p>你需要返回给定数组中的重要翻转对的数量。</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入</strong>: [1,3,2,3,1]
//<strong>输出</strong>: 2
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入</strong>: [2,4,3,5,1]
//<strong>输出</strong>: 3
//</pre>
//
//<p><strong>注意:</strong></p>
//
//<ol>
//	<li>给定数组的长度不会超过<code>50000</code>。</li>
//	<li>输入数组中的所有数字都在32位整数的表示范围内。</li>
//</ol>
//<div><div>Related Topics</div><div><li>树状数组</li><li>线段树</li><li>数组</li><li>二分查找</li><li>分治</li><li>有序集合</li><li>归并排序</li></div></div><br><div><li>👍 354</li><li>👎 0</li></div>

/**
 * [493]reverse-pairs
 *
 * @author 秦笑笑
 * @date 2022-05-22 18:04:23
 */
public class P493_ReversePairs {
    public static void main(String[] args) {
        Solution solution = new P493_ReversePairs().new Solution();
        solution.reversePairs(new int[]{1,3,2,3,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;
        int[] temp;

        public int reversePairs(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            System.out.println(ans);
            return ans;
        }

        public void sort(int[] nums, int start, int end) {
            // 当前为最小区间，不用再分
            if (start == end) return;
            int mid = start + ((end - start) >> 1);
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
            marge(nums, start, mid, end);
        }

        public void marge(int[] nums, int ol, int mid, int or) {
            // 用于保存排序前的状态
            for (int i = ol; i <= or; i++) {
                temp[i] = nums[i];
            }
            // 进行效率优化，维护左闭右开区间 [mid+1, end) 中的元素乘 2 小于 nums[i]
            // 为什么 end 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是一个空区间
            int start = ol;
            for (int i = mid + 1; i <= or; i++) {
                // nums 中的元素可能较大，乘 2 可能溢出，所以转化成 long
                while (start <= mid ) {
                    if ((long)nums[start] > (long)nums[i] * 2){
                        ans += mid - start + 1;
                        break;
                    }
                    start ++;
                }
            }
            int p = ol, q = mid + 1;
            for (int i = ol; i <= or; i++) {
                if (p == mid + 1) {//左数组已经执行合并结束
                    nums[i] = temp[q++];
                } else if (q == or + 1) { //右边数组归并结束
                    nums[i] = temp[p++];//nums[i] 为左侧最大值，满足 temp[left] > temp[right]
                } else if (temp[p] < temp[q]) {
                    nums[i] = temp[p++];
                } else {//temp[left] > temp[right] nums[i] 为右侧最小值
                    // 需要考虑一个问题，
                    // 当前左侧的数满足，则后续都满足
                    // 如果当前左侧的数不满足，后续的数就不满足了吗？？？
                    nums[i] = temp[q++];
                    long target = ((long)nums[i] * 2L);
                    for (int j = p; j <= mid; j++) {
                        // 左侧第一个数 满足条件，则后续所有的数都满足条件
                        if (target < (long)temp[j]) {
                            ans += mid - j + 1;
                            break;
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
