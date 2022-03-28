//<p>找出数组中重复的数字。</p>
//
//<p><br>
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>
//[2, 3, 1, 0, 2, 5, 3]
//<strong>输出：</strong>2 或 3 
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>2 &lt;= n &lt;= 100000</code></p>
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>排序</li></div></div><br><div><li>👍 793</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 03]数组中重复的数字
 * @author 秦笑笑
 * @date 2022-03-28 16:23:54
 */
public class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         *  类哈希
         *  n个数字，数字大小范围确定
         *  使用辅助数组，n被访问一次，num【n】计数+1
          * @param nums 排序数组
         * @return 重复数字
         */
    public int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            arr[num] ++;
            if (arr[num] > 1){
                res = num;
                return res;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
