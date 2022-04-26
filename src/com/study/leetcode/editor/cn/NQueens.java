//<p><strong>n&nbsp;皇后问题</strong> 研究的是如何将 <code>n</code>&nbsp;个皇后放置在 <code>n×n</code> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>
//
//<p>给你一个整数 <code>n</code> ，返回所有不同的&nbsp;<strong>n<em>&nbsp;</em>皇后问题</strong> 的解决方案。</p>
//
//<div class="original__bRMd">
//<div>
//<p>每一种解法包含一个不同的&nbsp;<strong>n 皇后问题</strong> 的棋子放置方案，该方案中 <code>'Q'</code> 和 <code>'.'</code> 分别代表了皇后和空位。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
//<pre>
//<strong>输入：</strong>n = 4
//<strong>输出：</strong>[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//<strong>解释：</strong>如上图所示，4 皇后问题存在两个不同的解法。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 1
//<strong>输出：</strong>[["Q"]]
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
//<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 1284</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [51]N 皇后
 * @author 秦笑笑
 * @date 2022-04-17 01:21:24
 */
public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        System.out.println(solution.solveNQueens(4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[] arr = new int[n];//用于存储已经摆放的皇后位置
        help(list,0,n,arr);
        return list;
    }
    private void help(List<List<String>> list,int row,int n,int[] arr){
        if (row == n){
            char[] temp = new char[n];
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Arrays.fill(temp,'.');
                temp[arr[i]] = 'Q';
                l.add(new String(temp));
            }
            list.add(l);
        }
        for (int i = 0; i < n; i++) {
            if (valid(row,i, n, arr)){
                int[] temp = Arrays.copyOf(arr,arr.length);
                temp[row] = i;
                help(list,row + 1,n,temp);
            }
        }
    }
    private boolean valid(int row, int col, int n, int[] arr){
        if (row == 0) return true;
        for (int i = 0; i < row; i++) {
            int l = arr[i];//已经放置皇后的列
            if (l == col || Math.abs(row - i) == Math.abs(l - col)){// 在用一列或者在同一斜线
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
