//<p>输入整数数组 <code>arr</code> ，找出其中最小的 <code>k</code> 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>arr = [3,2,1], k = 2
//<strong>输出：</strong>[1,2] 或者 [2,1]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>arr = [0,1,2,1], k = 1
//<strong>输出：</strong>[0]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>0 &lt;= k &lt;= arr.length &lt;= 10000</code></li>
//	<li><code>0 &lt;= arr[i]&nbsp;&lt;= 10000</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>快速选择</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 420</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * [剑指 Offer 40]最小的k个数
 *
 * @author 秦笑笑
 * @date 2022-04-19 00:17:22
 */
public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i : arr) {
                queue.offer(i);
            }
            int[] res = new int[k];
            int index = k - 1;
            while (!queue.isEmpty() && index >= 0) {
                res[index--] = queue.poll();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
