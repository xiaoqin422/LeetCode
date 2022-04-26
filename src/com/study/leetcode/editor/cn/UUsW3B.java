//<p>给定两个整数 <code>n</code> 和 <code>k</code>，返回 <code>1 ... n</code> 中所有可能的 <code>k</code> 个数的组合。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong>&nbsp;n = 4, k = 2
//<strong>输出:</strong>
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong>&nbsp;n = 1, k = 1
//<strong>输出: </strong>[[1]]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 20</code></li>
//	<li><code>1 &lt;= k &lt;= n</code></li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><meta charset="UTF-8" />注意：本题与主站 77&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/combinations/">https://leetcode-cn.com/problems/combinations/</a></p>
//<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 17</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [剑指 Offer II 080]含有 k 个元素的组合
 *
 * @author 秦笑笑
 * @date 2022-04-17 14:44:09
 */
public class UUsW3B {
    public static void main(String[] args) {
        Solution solution = new UUsW3B().new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            help(1, n, k);
            return list;
        }

        private void help(int cur, int n, int k) {
            // 剪枝：arr 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
            if (arr.size() + (n - cur + 1) < k) {
                return;
            }
            if (arr.size() == k) {
                list.add(new ArrayList<>(arr));
                return;
            }
            arr.add(cur);
            help(cur + 1, n, k);
            arr.remove(arr.size() - 1); //手动回溯
            help(cur + 1, n, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
