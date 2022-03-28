//<p>在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。</p>
//
//<p> </p>
//
//<p><strong>示例:</strong></p>
//
//<p>现有矩阵 matrix 如下：</p>
//
//<pre>
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//</pre>
//
//<p>给定 target = <code>5</code>，返回 <code>true</code>。</p>
//
//<p>给定 target = <code>20</code>，返回 <code>false</code>。</p>
//
//<p> </p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 <= n <= 1000</code></p>
//
//<p><code>0 <= m <= 1000</code></p>
//
//<p> </p>
//
//<p><strong>注意：</strong>本题与主站 240 题相同：<a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">https://leetcode-cn.com/problems/search-a-2d-matrix-ii/</a></p>
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治</li><li>矩阵</li></div></div><br><div><li>👍 632</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 04]二维数组中的查找
 * @author 秦笑笑
 * @date 2022-03-28 16:31:33
 */
public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 二叉搜索树
          * @param matrix
         * @param target
         * @return
         */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //行
        int n = matrix.length;
        if (n == 0){
            return false;
        }
        // 列
        int m = matrix[0].length;
        if (m == 0){
            return false;
        }
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0){
            int index = matrix[row][col];
            if (index == target) return true;
            else if (index < target){
                row ++;
            }else {
                col --;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
