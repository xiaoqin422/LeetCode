//<p>数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。</p>
//
//<p>&nbsp;</p>
//
//<p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre><strong>输入:</strong> [1, 2, 3, 2, 2, 2, 5, 4, 2]
//<strong>输出:</strong> 2</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>1 &lt;= 数组长度 &lt;= 50000</code></p>
//
//<p>&nbsp;</p>
//
//<p>注意：本题与主站 169 题相同：<a href="https://leetcode-cn.com/problems/majority-element/">https://leetcode-cn.com/problems/majority-element/</a></p>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>分治</li><li>计数</li><li>排序</li></div></div><br><div><li>👍 275</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * [剑指 Offer 39]数组中出现次数超过一半的数字
 * @author 秦笑笑
 * @date 2022-04-18 23:07:45
 */
public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
        System.out.println(solution.majorityElement(new int[]{1,2,3,2,2,2,5,4,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0);
            if (orDefault >= (nums.length >> 1)) {
                result = num;
            }else {
                map.put(num, orDefault + 1);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
