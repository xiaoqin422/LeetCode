//<p>0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。</p>
//
//<p>例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入:</strong> n = 5, m = 3
//<strong>输出: </strong>3
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入:</strong> n = 10, m = 17
//<strong>输出: </strong>2
//</pre>
//
//<p> </p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>1 <= n <= 10^5</code></li>
//	<li><code>1 <= m <= 10^6</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>递归</li><li>数学</li></div></div><br><div><li>👍 598</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 62]圆圈中最后剩下的数字
 * @author 秦笑笑
 * @date 2022-04-25 23:08:57
 */
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        System.out.println(solution.lastRemaining(70866, 116922));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        int[][] arr = new int[n][2];
        int index = 0; //当前扫描的索引 当index % m == 0 删除当前扫描
        int count = 0; // 循环退出条件  当count = n - 1 剩余最后一个
        for (int i = 0; i < n; ) {
            arr[i][0] = i;
            if (arr[i][1] == 1){
                // 重复循环
                i++;
                if (i == n){
                    i = 0;
                }
                continue;
            }
            index ++;
            if (index % m == 0){
                arr[i][1] = 1; //逻辑删除
                count ++;
                if (count == n - 1) break;
            }
            i++;
            if (i == n){
                i = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i][1] == 0){
                return i;
            }
        }
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
