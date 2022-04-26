//<p>在一个数组 <code>nums</code> 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>nums = [3,4,3,3]
//<strong>输出：</strong>4
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>nums = [9,1,7,9,7,9,7]
//<strong>输出：</strong>1</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 10000</code></li>
//	<li><code>1 &lt;= nums[i] &lt; 2^31</code></li>
//</ul>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>位运算</li><li>数组</li></div></div><br><div><li>👍 328</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * [剑指 Offer 56 - II]数组中数字出现的次数 II
 * @author 秦笑笑
 * @date 2022-04-24 13:47:25
 */
public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        // 记录所有数字2进制 各位置1的数量
        int[] arr = new int[32];
        for (int item : nums) {
            for (int i = 0; i < 32; i++) {
                arr[i] += item & 1;
                item >>=1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= arr[31 - i] % 3;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
