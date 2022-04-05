//<p>地上有一个m行n列的方格，从坐标 <code>[0,0]</code> 到坐标 <code>[m-1,n-1]</code> 。一个机器人从坐标 <code>[0, 0] </code>的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>m = 2, n = 3, k = 1
//<strong>输出：</strong>3
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>m = 3, n = 1, k = 0
//<strong>输出：</strong>1
//</pre>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n,m &lt;= 100</code></li>
//	<li><code>0 &lt;= k&nbsp;&lt;= 20</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>动态规划</li></div></div><br><div><li>👍 477</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 13]机器人的运动范围
 *
 * @author 秦笑笑
 * @date 2022-03-29 21:52:03
 */
public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        System.out.println(solution.movingCount(38, 15, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] arr;
        int rows,cols;
        public int movingCount(int m, int n, int k) {
            // 生成矩阵
            arr = new boolean[m][n];
            this.rows = m;
            this.cols = n;
            return dfs(0,0,k);
        }
        public int dfs(int m, int n,int k){
            if (m >= rows || n >= cols || arr[m][n] || getNum(m,n) > k){
                return 0;
            }
            arr[m][n] = true;
            return 1 + dfs(m,n + 1,k) + dfs(m + 1,n,k);
        }

        public int getNum(int m, int n){
            int num = 0;
            while (m > 0){
                num += m % 10;
                m /= 10;
            }
            while (n > 0){
                num += n % 10;
                n /= 10;
            }
            return num;
        }



    }
    class Solution1 {
        int[][] arr;
        int count;
        int m;
        int n;

        public int movingCount(int m, int n, int k) {
            // 生成矩阵
            generate(m, n, k);
            this.m = m;
            this.n = n;
            list(0, 0);
            return count;
        }

        public void list(int m, int n) {
            if (!check(m, n)) return;
            arr[m][n] = 2;
            count++;
            if (check(m, n - 1)) {
                list(m, n - 1);
            }
            if (check(m, n + 1)) {
                list(m, n + 1);
            }
            if (check(m - 1, n)) {
                list(m - 1, n);
            }
            if (check(m + 1, n)) {
                list(m + 1, n);
            }
        }

        public boolean check(int row, int col) {
            if (row >= 0 && col >= 0 && row < m && col < n && arr[row][col] == 1) {
                return true;
            }
            return false;
        }

        public void generate(int m, int n, int k) {
            arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int num1 = i;
                    int num2 = j;
                    while (num1 > 0){
                        arr[i][j] += num1 % 10;
                        num1 /= 10;
                    }
                    while (num2 > 0){
                        arr[i][j] += num2 % 10;
                        num2 /= 10;
                    }
                    arr[i][j] = arr[i][j] <= k ? 1 : 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
