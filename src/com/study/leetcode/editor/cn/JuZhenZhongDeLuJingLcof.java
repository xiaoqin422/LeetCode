//<p>给定一个 <code>m x n</code> 二维字符网格 <code>board</code> 和一个字符串单词 <code>word</code> 。如果 <code>word</code> 存在于网格中，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
//
//<p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。</p>
//
//<p> </p>
//
//<p>例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。</p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;" /></p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>board = [["a","b"],["c","d"]], word = "abcd"
//<strong>输出：</strong>false
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= board.length <= 200</code></li>
//	<li><code>1 <= board[i].length <= 200</code></li>
//	<li><code>board</code> 和 <code>word</code> 仅由大小写英文字母组成</li>
//</ul>
//
//<p> </p>
//
//<p><strong>注意：</strong>本题与主站 79 题相同：<a href="https://leetcode-cn.com/problems/word-search/">https://leetcode-cn.com/problems/word-search/</a></p>
//<div><div>Related Topics</div><div><li>数组</li><li>回溯</li><li>矩阵</li></div></div><br><div><li>👍 561</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import javax.xml.stream.FactoryConfigurationError;

/**
 * [剑指 Offer 12]矩阵中的路径
 *
 * @author 秦笑笑
 * @date 2022-03-29 17:44:43
 */
public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        char[][] c = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.println(solution.exist(c, "AAB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String word;
        char[][] board;
        int rows;
        int cols;

        public boolean exist(char[][] board, String word) {
            if (word.length() == 0) return false;
            this.board = board;
            this.word = word;
            rows = board.length;
            cols = board[0].length;
            if (rows * cols >= word.length()){
                char head = word.charAt(0);
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (board[i][j] == head &&search(1,i,j)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean search(int index, int row, int col) {
            if (index >= word.length()) return true;
            char target = word.charAt(index);
            boolean flag = false;
            char temp = board[row][col];
            board[row][col] = '/';
            if (check(row, col - 1,target)) {
                flag = search(index + 1, row, col - 1);
            }
            if (!flag && check(row, col + 1,target)) {
                flag = search(index + 1, row, col + 1);
            }
            if (!flag && check(row - 1, col,target)) {
                flag = search(index + 1, row - 1, col);
            }
            if (!flag && check(row + 1, col,target)) {
                flag = search(index + 1, row + 1, col);
            }
            board[row][col] = temp;
            return flag;
        }

        private boolean check(int row, int col,char target) {
            return row >= 0 && col >= 0 && row < rows && col < cols && board[row][col] == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
