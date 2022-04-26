//<p>输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre><strong>输入:</strong> <code>[10,2]</code>
//<strong>输出:</strong> &quot;<code>102&quot;</code></pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre><strong>输入:</strong> <code>[3,30,34,5,9]</code>
//<strong>输出:</strong> &quot;<code>3033459&quot;</code></pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>0 &lt; nums.length &lt;= 100</code></li>
//</ul>
//
//<p><strong>说明: </strong></p>
//
//<ul>
//	<li>输出结果可能非常大，所以你需要返回一个字符串而不是整数</li>
//	<li>拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0</li>
//</ul>
//<div><div>Related Topics</div><div><li>贪心</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 441</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/**
 * [剑指 Offer 45]把数组排成最小的数
 *
 * @author 秦笑笑
 * @date 2022-04-20 18:50:06
 */
public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        System.out.println(solution.minNumber(new int[]{1,2,3,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    //字典序列小的放在堆顶
                    return (o1 + o2).compareTo(o2 + o1);
                }
            });
            for (int num : nums) {
                queue.add(String.valueOf(num));
            }
            StringBuilder res = new StringBuilder();
            while (! queue.isEmpty()){
                res.append(queue.poll());
            }
            return res.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
