//<p>在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre><strong>输入:</strong> 
//<code>[
//&nbsp; [1,3,1],
//&nbsp; [1,5,1],
//&nbsp; [4,2,1]
//]</code>
//<strong>输出:</strong> <code>12
//</code><strong>解释:</strong> 路径 1&rarr;3&rarr;5&rarr;2&rarr;1 可以拿到最多价值的礼物</pre>
//
//<p>&nbsp;</p>
//
//<p>提示：</p>
//
//<ul>
//	<li><code>0 &lt; grid.length &lt;= 200</code></li>
//	<li><code>0 &lt; grid[0].length &lt;= 200</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div><br><div><li>👍 281</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 47]礼物的最大价值
 *
 * @author 秦笑笑
 * @date 2022-04-23 10:29:30
 */
public class LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 记录礼物最大价值
        int max = 0;
        int[][] grid;
        int[][] dp;
        int cols;
        int rows;

        public int maxValue(int[][] grid) {
            if (grid.length <= 0 || grid[0].length <= 0) return -1;
            rows = grid.length;
            cols = grid[0].length;
            this.grid = grid;
            dp = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = grid[i][j];
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        dp[i][j] = grid[i][j] + Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[rows - 1][cols - 1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
