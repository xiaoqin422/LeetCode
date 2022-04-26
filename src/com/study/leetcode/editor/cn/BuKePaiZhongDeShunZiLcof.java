//<p>从<strong>若干副扑克牌</strong>中随机抽 <code>5</code> 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre>
//<strong>输入:</strong> [1,2,3,4,5]
//<strong>输出:</strong> True</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre>
//<strong>输入:</strong> [0,0,1,2,5]
//<strong>输出:</strong> True</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p>数组长度为 5&nbsp;</p>
//
//<p>数组的数取值为 [0, 13] .</p>
//<div><div>Related Topics</div><div><li>数组</li><li>排序</li></div></div><br><div><li>👍 234</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [剑指 Offer 61]扑克牌中的顺子
 * @author 秦笑笑
 * @date 2022-04-25 17:03:02
 */
public class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        System.out.println(solution.isStraight(new int[]{11, 0, 9, 0, 0}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        int count = 0;
        int last = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == 0){
                count ++;
            }else if(num == last) {
                return false;
            }
            last = num;
        }
        return nums[nums.length - 1] - nums[count] < 5; //最大牌-最小排小于5
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
