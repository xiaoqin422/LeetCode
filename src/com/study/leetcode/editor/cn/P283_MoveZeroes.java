package com.study.leetcode.editor.cn;
//<p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>
//
//<p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = <code>[0,1,0,3,12]</code>
//<strong>输出:</strong> <code>[1,3,12,0,0]</code>
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = <code>[0]</code>
//<strong>输出:</strong> <code>[0]</code></pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示</strong>:</p>
//<meta charset="UTF-8" />
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 1568</li><li>👎 0</li></div>

/**
 * [283]move-zeroes
 * @author 秦笑笑
 * @date 2022-05-02 20:19:51
 */
public class P283_MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283_MoveZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0,fast = 0;
        while (fast < len){
            if (nums[fast] != 0){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        while (slow < len){
            nums[slow] = 0;
            slow ++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
