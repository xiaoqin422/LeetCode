//<p>一个整型数组 <code>nums</code> 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>nums = [4,1,4,6]
//<strong>输出：</strong>[1,6] 或 [6,1]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>nums = [1,2,10,4,1,4,3,3]
//<strong>输出：</strong>[2,10] 或 [10,2]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>2 &lt;= nums.length &lt;= 10000</code></li>
//</ul>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>位运算</li><li>数组</li></div></div><br><div><li>👍 614</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 56 - I]数组中数字出现的次数
 *
 * @author 秦笑笑
 * @date 2022-04-24 13:20:22
 */
public class ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int n = 0;
            for (int num : nums) {
                n ^= num;
            }
            int temp = 1;
            // 找出第一个不相同的 位数  1 1 0 1
            //                      1 0 0 1    temp应该为 0100
            // while ((n & temp) == 0) {
            //     temp = temp << 1;
            // }
            temp = n &(~n + 1);
            int[] res = new int[2];
            for (int num : nums) {
                if ((temp & num) == temp){ //所有这一位置为 1的数进行  异或  （该位置相同的有偶数次，异或最后剩下一个即为目标值）
                    res[0] ^= num;
                }
            }
            res[1] = n ^ res[0];
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
