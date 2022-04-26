//<p>你将得到一个整数数组 <code>matchsticks</code> ，其中 <code>matchsticks[i]</code> 是第 <code>i</code>&nbsp;个火柴棒的长度。你要用 <strong>所有的火柴棍</strong>&nbsp;拼成一个正方形。你 <strong>不能折断</strong> 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 <strong>使用一次</strong> 。</p>
//
//<p>如果你能使这个正方形，则返回 <code>true</code> ，否则返回 <code>false</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2021/04/09/matchsticks1-grid.jpg" /></p>
//
//<pre>
//<strong>输入:</strong> matchsticks = [1,1,2,2,2]
//<strong>输出:</strong> true
//<strong>解释:</strong> 能拼成一个边长为2的正方形，每边两根火柴。
//</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre>
//<strong>输入:</strong> matchsticks = [3,3,3,3,4]
//<strong>输出:</strong> false
//<strong>解释:</strong> 不能用所有火柴拼成一个正方形。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= matchsticks.length &lt;= 15</code></li>
//	<li><code>1 &lt;= matchsticks[i] &lt;= 10<sup>8</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>动态规划</li><li>回溯</li><li>状态压缩</li></div></div><br><div><li>👍 256</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.*;

/**
 * [473]火柴拼正方形
 *
 * @author 秦笑笑
 * @date 2022-04-18 15:40:50
 */
public class MatchsticksToSquare {
    public static void main(String[] args) {
        Solution solution = new MatchsticksToSquare().new Solution();
        System.out.println(solution.makesquare(new int[]{20,13,19,19,4,15,10,5,5,15,14,11,3,20,11}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> list = new ArrayList<>();
        // 每条边一个桶
        int[] nums = new int[4];
        int subMax;

        public boolean makesquare(int[] matchsticks) {
            if (matchsticks == null || matchsticks.length < 4) return false;
            Arrays.sort(matchsticks);
            int sum = 0;
            for (int i = matchsticks.length - 1; i >= 0; i--) {
                list.add(matchsticks[i]);
                sum += matchsticks[i];
            }
            subMax = sum / 4;
            if (subMax * 4 != sum) return false;

            return dfs(0);
        }

        private boolean dfs(int index) {
            // 所有的火柴都用完
            if (index == list.size()) {
                return nums[0] == nums[1] && nums[1] == nums[2] && nums[2] == nums[3];
            }
            Integer element = list.get(index);
            // 从第一遍边/桶 开始装
            for (int i = 0; i < nums.length; i++) {
                // 如果该边长大于 可能的边长 则开始组装下一个桶
                // if (nums[i] + element >= subMax) continue;
                if (nums[i] + element <= subMax) {
                    nums[i] += element;
                    if (dfs(index + 1)) {
                        return true;
                    }
                    nums[i] -= element;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
