package com.study.leetcode.editor.cn;
//<p>给你一个 <code>m</code> 行 <code>n</code> 列的矩阵 <code>matrix</code> ，请按照 <strong>顺时针螺旋顺序</strong> ，返回矩阵中的所有元素。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg" style="width: 242px; height: 242px;" />
//<pre>
//<strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
//<strong>输出：</strong>[1,2,3,6,9,8,7,4,5]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg" style="width: 322px; height: 242px;" />
//<pre>
//<strong>输入：</strong>matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//<strong>输出：</strong>[1,2,3,4,8,12,11,10,9,5,6,7]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>m == matrix.length</code></li>
//	<li><code>n == matrix[i].length</code></li>
//	<li><code>1 <= m, n <= 10</code></li>
//	<li><code>-100 <= matrix[i][j] <= 100</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><br><div><li>👍 1081</li><li>👎 0</li></div>

import java.util.ArrayList;
import java.util.List;

/**
 * [54]spiral-matrix
 * @author 秦笑笑
 * @date 2022-05-03 16:20:22
 */
public class P054_SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P054_SpiralMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int upper_bound = 0, lower_bound = rows - 1;
        int left_bound = 0,right_bound = cols - 1;
        while (ans.size() < rows * cols ){
            // 添加第一行 从上到下，上边界小于右边界
            if (upper_bound <= lower_bound){
                // 从左向右
                for (int j = left_bound; j <= right_bound; j++) {
                    ans.add(matrix[upper_bound][j]);
                }
                upper_bound ++;//上边界下移
            }
            if (left_bound <= right_bound){
                // 从上到下
                for (int i = upper_bound; i <= lower_bound; i++) {
                    ans.add(matrix[i][right_bound]);
                }
                right_bound--;
            }
            if (upper_bound <= lower_bound){
                for (int j = right_bound; j >= left_bound; j--) {
                    ans.add(matrix[lower_bound][j]);
                }
                lower_bound --;
            }
            if (left_bound <= right_bound){
                for (int i = lower_bound; i >= upper_bound; i--) {
                    ans.add(matrix[i][left_bound]);
                }
                left_bound++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
