//<p>给定一个数组 <code>nums</code> 和滑动窗口的大小 <code>k</code>，请找出所有滑动窗口里的最大值。</p>
//
//<p><strong>示例:</strong></p>
//
//<pre><strong>输入:</strong> <em>nums</em> = <code>[1,3,-1,-3,5,3,6,7]</code>, 和 <em>k</em> = 3
//<strong>输出: </strong><code>[3,3,5,5,6,7] 
//<strong>解释: 
//</strong></code>
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<p>你可以假设 <em>k </em>总是有效的，在输入数组不为空的情况下，1 &le; k &le;&nbsp;输入数组的大小。</p>
//
//<p>注意：本题与主站 239 题相同：<a href="https://leetcode-cn.com/problems/sliding-window-maximum/">https://leetcode-cn.com/problems/sliding-window-maximum/</a></p>
//<div><div>Related Topics</div><div><li>队列</li><li>滑动窗口</li><li>单调队列</li><li>堆（优先队列）</li></div></div><br><div><li>👍 428</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * [剑指 Offer 59 - I]滑动窗口的最大值
 *
 * @author 秦笑笑
 * @date 2022-04-25 13:14:45
 */
public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //  单调队列
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 记录上一次滑窗的起始位置
            int index = 0;
            if (nums.length == 0) return new int[0];
            int[] res = new int[nums.length - k + 1];
            // first 最大值   last最小值
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                // 如果新添加的 窗口大于已经存在的窗口，那最大值一定不是之前的，直接删除
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                    deque.pollLast();
                }
                // 添加新的窗口
                deque.offerLast(i);
            }
            res[index++] = nums[deque.peekFirst()];
            for (int i = k; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.offerLast(i);
                // 如果最大的 不是该窗口内的，进行移除(窗口现在最左边的下标 i - k + 1)
                while (deque.peekFirst() <= i - k){
                    deque.pollFirst();
                }
                res[index++] = nums[deque.peekFirst()];
            }
            return res;
        }

        //  优先级队列
        public int[] maxSlidingWindow1(int[] nums, int k) {
            // 记录上一次滑窗的起始位置
            int index = 0;
            int len = nums.length == 0 ? 0 : nums.length - k + 1;
            int[] res = new int[len];
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
            for (int i = 0; i < nums.length; i++) {
                queue.offer(nums[i]);
                if (i >= k - 1) {
                    res[index] = queue.peek();
                    queue.remove(nums[index]);
                    index++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
