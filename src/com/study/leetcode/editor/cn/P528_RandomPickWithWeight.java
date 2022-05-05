package com.study.leetcode.editor.cn;
//<p>给你一个 <strong>下标从 0 开始</strong> 的正整数数组&nbsp;<code>w</code> ，其中&nbsp;<code>w[i]</code> 代表第 <code>i</code> 个下标的权重。</p>
//
//<p>请你实现一个函数&nbsp;<code>pickIndex</code>&nbsp;，它可以 <strong>随机地</strong> 从范围 <code>[0, w.length - 1]</code> 内（含 <code>0</code> 和 <code>w.length - 1</code>）选出并返回一个下标。选取下标 <code>i</code>&nbsp;的 <strong>概率</strong> 为 <code>w[i] / sum(w)</code> 。</p>
//
//<ol>
//</ol>
//
//<ul>
//	<li>例如，对于 <code>w = [1, 3]</code>，挑选下标 <code>0</code> 的概率为 <code>1 / (1 + 3)&nbsp;= 0.25</code> （即，25%），而选取下标 <code>1</code> 的概率为 <code>3 / (1 + 3)&nbsp;= 0.75</code>（即，<code>75%</code>）。</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>
//["Solution","pickIndex"]
//[[[1]],[]]
//<strong>输出：</strong>
//[null,0]
//<strong>解释：</strong>
//Solution solution = new Solution([1]);
//solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//<strong>输出：</strong>
//[null,1,1,1,1,0]
//<strong>解释：</strong>
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//
//由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//诸若此类。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= w.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>1 &lt;= w[i] &lt;= 10<sup>5</sup></code></li>
//	<li><code>pickIndex</code>&nbsp;将被调用不超过 <code>10<sup>4</sup></code>&nbsp;次</li>
//</ul>
//<div><div>Related Topics</div><div><li>数学</li><li>二分查找</li><li>前缀和</li><li>随机化</li></div></div><br><div><li>👍 230</li><li>👎 0</li></div>

import java.util.Random;

/**
 * [528]random-pick-with-weight
 *
 * @author 秦笑笑
 * @date 2022-05-05 19:41:35
 */
public class P528_RandomPickWithWeight {
    public static void main(String[] args) {
        Solution solution = new P528_RandomPickWithWeight().new Solution(new int[1]);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 前缀和数组
        private final int[] preNum;
        private Random rand = new Random();

        public Solution(int[] w) {
            preNum = new int[w.length + 1];
            preNum[0] = 0;
            for (int i = 0; i < w.length; i++) {
                preNum[i + 1] = preNum[i] + w[i];
            }
        }


        public int pickIndex() {
            int n = preNum.length;
            // 在闭区间 [1, preSum[n - 1]] 中随机选择一个数字
            int random = rand.nextInt(preNum[n - 1]) + 1;
            return left_bound(random) - 1;
        }

        // 在前缀和寻找小于等于target的最小数下标 ===== 二分查找寻找左边界
        private int left_bound(int target) {
            if (preNum.length == 0) return -1;
            int left = 0, right = preNum.length;
            while (left < right) {
                int mid = ((right - left) >> 1) + left;
                if (preNum[mid] == target) {
                    right = mid;
                } else if (preNum[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
