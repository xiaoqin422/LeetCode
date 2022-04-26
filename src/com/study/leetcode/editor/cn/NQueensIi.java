//<p><strong>n&nbsp;皇后问题</strong> 研究的是如何将 <code>n</code>&nbsp;个皇后放置在 <code>n × n</code> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>
//
//<p>给你一个整数 <code>n</code> ，返回 <strong>n 皇后问题</strong> 不同的解决方案的数量。</p>
//
//<p>&nbsp;</p>
//
//<div class="original__bRMd">
//<div>
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
//<pre>
//<strong>输入：</strong>n = 4
//<strong>输出：</strong>2
//<strong>解释：</strong>如上图所示，4 皇后问题存在两个不同的解法。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 1
//<strong>输出：</strong>1
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 9</code></li>
//</ul>
//</div>
//</div>
//<div><div>Related Topics</div><div><li>回溯</li></div></div><br><div><li>👍 354</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [52]N皇后 II
 *
 * @author 秦笑笑
 * @date 2022-04-17 01:38:34
 */
public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        System.out.println(solution.totalNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            int[] arr = new int[n];//用于存储已经摆放的皇后位置
            return help(0,n,arr);
        }

        private int help(int row, int n, int[] arr) {
            int size = 0;
            if (row == n) {
                return ++size;
            }
            for (int i = 0; i < n; i++) {
                if (valid(row, i, n, arr)) {
                    int[] temp = Arrays.copyOf(arr, arr.length);
                    temp[row] = i;
                    size += help(row + 1, n, temp);
                }
            }
            return size;
        }

        private boolean valid(int row, int col, int n, int[] arr) {
            if (row == 0) return true;
            for (int i = 0; i < row; i++) {
                int l = arr[i];//已经放置皇后的列
                if (l == col || Math.abs(row - i) == Math.abs(l - col)) {// 在用一列或者在同一斜线
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
