package com.study.leetcode.editor.cn;
//<p>给你一个正整数 <code>n</code> ，生成一个包含 <code>1</code> 到 <code>n<sup>2</sup></code> 所有元素，且元素按顺时针顺序螺旋排列的 <code>n x n</code> 正方形矩阵 <code>matrix</code> 。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg" style="width: 242px; height: 242px;" />
//<pre>
//<strong>输入：</strong>n = 3
//<strong>输出：</strong>[[1,2,3],[8,9,4],[7,6,5]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 1
//<strong>输出：</strong>[[1]]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= n <= 20</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 698</li><li>👎 0</li></div>

/**
 * [59]spiral-matrix-ii
 *
 * @author 秦笑笑
 * @date 2022-05-03 16:59:10
 */
public class P059_SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P059_SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int num = 1;
            int upper_bound = 0, lower_bound = n - 1;
            int left_bound = 0, right_bound = n - 1;
            int[][] ans = new int[n][n];
            while (num <= n * n) {
                if (upper_bound <= lower_bound) {
                    for (int j = left_bound; j <= right_bound; j++) {
                        ans[upper_bound][j] = num++;
                    }
                    upper_bound++;
                }
                if (left_bound <= right_bound) {
                    for (int i = upper_bound; i <= lower_bound; i++) {
                        ans[i][right_bound] = num++;
                    }
                    right_bound--;
                }
                if (upper_bound <= lower_bound) {
                    for (int j = right_bound; j >= left_bound; j--) {
                        ans[lower_bound][j] = num++;
                    }
                    lower_bound--;
                }
                if (left_bound <= right_bound) {
                    for (int i = lower_bound; i >= upper_bound; i--) {
                        ans[i][left_bound] = num++;
                    }
                    left_bound++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
