//<p>我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例:</strong></p>
//
//<pre><strong>输入:</strong> n = 10
//<strong>输出:</strong> 12
//<strong>解释: </strong><code>1, 2, 3, 4, 5, 6, 8, 9, 10, 12</code> 是前 10 个丑数。</pre>
//
//<p><strong>说明:&nbsp;</strong>&nbsp;</p>
//
//<ol>
//	<li><code>1</code>&nbsp;是丑数。</li>
//	<li><code>n</code>&nbsp;<strong>不超过</strong>1690。</li>
//</ol>
//
//<p>注意：本题与主站 264 题相同：<a href="https://leetcode-cn.com/problems/ugly-number-ii/">https://leetcode-cn.com/problems/ugly-number-ii/</a></p>
//<div><div>Related Topics</div><div><li>哈希表</li><li>数学</li><li>动态规划</li><li>堆（优先队列）</li></div></div><br><div><li>👍 331</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.*;

/**
 * [剑指 Offer 49]丑数
 * @author 秦笑笑
 * @date 2022-04-23 12:51:08
 */
public class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        solution.nthUglyNumber(10);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Integer> set = new TreeSet<>();
        // 用于记录该值是否已经加入优先级队列
        int[] help = new int[1691];
        // 将1加入优先级队列
        set.add(1);
        int[] arr = new int[]{2,3,5};
        // 当前质因子的 倍数
        int p = 1;
        while (set.size() < n){
            for (int i : arr) {
                int cur = i * p;
                set.add(cur);
            }
            p++;
        }
        Integer[] array = set.toArray(new Integer[0]);
        return array[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
