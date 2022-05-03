package com.study.leetcode.editor.cn;
//<p>给定一个 <em>n&nbsp;</em>×&nbsp;<em>n</em> 的二维矩阵&nbsp;<code>matrix</code> 表示一个图像。请你将图像顺时针旋转 90 度。</p>
//
//<p>你必须在<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 旋转图像，这意味着你需要直接修改输入的二维矩阵。<strong>请不要 </strong>使用另一个矩阵来旋转图像。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="height: 188px; width: 500px;" />
//<pre>
//<strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
//<strong>输出：</strong>[[7,4,1],[8,5,2],[9,6,3]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="height: 201px; width: 500px;" />
//<pre>
//<strong>输入：</strong>matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//<strong>输出：</strong>[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>n == matrix.length == matrix[i].length</code></li>
//	<li><code>1 &lt;= n &lt;= 20</code></li>
//	<li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li>
//</ul>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>矩阵</li></div></div><br><div><li>👍 1271</li><li>👎 0</li></div>

/**
 * [48]rotate-image
 * @author 秦笑笑
 * @date 2022-05-03 16:02:33
 */
public class P048_RotateImage {
    public static void main(String[] args) {
        Solution solution = new P048_RotateImage().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 难点在：  行变列   解决思路 对称交换两次 ①斜边对称、②中间对称
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 斜边对称交换
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                swap(matrix,i,j,j,i);
            }
        }
        // 中间对称交换
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                swap(matrix,i,j,i ,cols - j - 1);
            }
        }
    }
    // 两个点交换
    private void swap(int[][] arr, int row1, int col1,int row2,int col2){
        int temp = arr[row1][col1];
        arr[row1][col1] = arr[row2][col2];
        arr[row2][col2] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
