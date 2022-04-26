//<p>设计一种算法，打印 N 皇后在 N &times; N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的&ldquo;对角线&rdquo;指的是所有的对角线，不只是平分整个棋盘的那两条对角线。</p>
//
//<p><strong>注意：</strong>本题相对原题做了扩展</p>
//
//<p><strong>示例:</strong></p>
//
//<pre><strong> 输入</strong>：4
//<strong> 输出</strong>：[[&quot;.Q..&quot;,&quot;...Q&quot;,&quot;Q...&quot;,&quot;..Q.&quot;],[&quot;..Q.&quot;,&quot;Q...&quot;,&quot;...Q&quot;,&quot;.Q..&quot;]]
//<strong> 解释</strong>: 4 皇后问题存在如下两个不同的解法。
//[
//&nbsp;[&quot;.Q..&quot;, &nbsp;// 解法 1
//&nbsp; &quot;...Q&quot;,
//&nbsp; &quot;Q...&quot;,
//&nbsp; &quot;..Q.&quot;],
//
//&nbsp;[&quot;..Q.&quot;, &nbsp;// 解法 2
//&nbsp; &quot;Q...&quot;,
//&nbsp; &quot;...Q&quot;,
//&nbsp; &quot;.Q..&quot;]
//]
//</pre>
//<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 139</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.*;

/**
 * [面试题 08.12]八皇后
 *
 * @author 秦笑笑
 * @date 2022-04-16 21:49:50
 */
public class EightQueensLcci {
    public static void main(String[] args) {
        Solution solution = new EightQueensLcci().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List< Map<Integer,String>> h = new ArrayList<>();
        int n ;
        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            List<List<String>> list = new ArrayList<>();
            int[] array = new int[n];
            dfs(list,0,array);
            return list;
        }

        private void dfs(List<List<String>> list,int row, int[] array) {
            if (row == n){
                list.add(generate(array));
            }
            for (int j = 0; j < n; j++) {
                if (check(row,j,array)){
                    int[] temp = Arrays.copyOf(array,array.length);
                    temp[row] = j;//不满足自动回溯  满足直接执行到最后保存结果
                    dfs(list,row + 1,temp);
                }
            }
        }
        private List<String> generate(int[] array){
            List<String> list = new ArrayList<>();
            char[] chars = new char[n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(chars,'.');
                chars[array[i]] = 'Q';
                list.add(new String(chars));
            }
            return list;
        }
        private boolean check(int row,int col,int[] array){
            if (row == 0) return true;
            for (int i = 0; i < row; i++) {
                if (Math.abs(row - i) == Math.abs(col - array[i])  || col == array[i]){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
