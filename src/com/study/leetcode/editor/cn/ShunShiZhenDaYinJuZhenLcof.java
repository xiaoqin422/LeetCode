//<p>输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
//<strong>输出：</strong>[1,2,3,6,9,8,7,4,5]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>matrix =&nbsp;[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//<strong>输出：</strong>[1,2,3,4,8,12,11,10,9,5,6,7]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>0 &lt;= matrix.length &lt;= 100</code></li>
//	<li><code>0 &lt;= matrix[i].length&nbsp;&lt;= 100</code></li>
//</ul>
//
//<p>注意：本题与主站 54 题相同：<a href="https://leetcode-cn.com/problems/spiral-matrix/">https://leetcode-cn.com/problems/spiral-matrix/</a></p>
//<div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 385</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [剑指 Offer 29]顺时针打印矩阵
 * @author 秦笑笑
 * @date 2022-04-05 17:17:48
 */
public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] ints = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(Arrays.toString(solution.spiralOrder(ints)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[cols * rows];
        int row = 0, col = 0;
        int count = 0;
        while (count < res.length){
            int index = row;
            int index1 = count;
            while (count < res.length &&col < cols - 1){
                res[count++] = matrix[row][col++];
            }
            while (count < res.length && row < rows - 1){
                res[count++] = matrix[row++][col];
            }
            while (count < res.length && col > index){
                res[count++] = matrix[row][col--];
            }
            while (count < res.length && row > index){
                res[count++] = matrix[row--][col];
            }
            if (count == index1){
                res[count] = matrix[row][col];
                break;
            }else {
                col ++;
                row ++;
                rows --;
                cols --;

            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
