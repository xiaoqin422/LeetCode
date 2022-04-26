//<p>输入一个正整数 <code>target</code> ，输出所有和为 <code>target</code> 的连续正整数序列（至少含有两个数）。</p>
//
//<p>序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>target = 9
//<strong>输出：</strong>[[2,3,4],[4,5]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>target = 15
//<strong>输出：</strong>[[1,2,3,4,5],[4,5,6],[7,8]]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= target &lt;= 10^5</code></li>
//</ul>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>数学</li><li>双指针</li><li>枚举</li></div></div><br><div><li>👍 428</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [剑指 Offer 57 - II]和为s的连续正数序列
 *
 * @author 秦笑笑
 * @date 2022-04-25 10:13:00
 */
public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        solution.findContinuousSequence(15);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 数学解法  前n项之和
        public int[][] findContinuousSequence(int target) {
            List<int[]> list = new ArrayList<>();
            int l = 1,r = 2;
            int mid = target / 2;
            while (l < r && l <= mid){
                int num = (l + r) * (r - l + 1);
                int sum =  num / 2;// 前n项之和
                if (num % 2 != 0 || sum < target){
                    r ++;
                }else {
                    if (sum == target){//前n项和 等于目标值
                        int[] arr = new int[r - l + 1];
                        int index = 0;
                        for (int i = l; i <= r; i++) {
                            arr[index ++] = i;
                        }
                        list.add(arr);
                    }
                    l++;
                }
            }
            return list.toArray(new int[list.size()][]);
        }
        // 数学解法  前n项之和
        public int[][] findContinuousSequence1(int target) {
            int n = target / 2;
            List<int[]> list = new ArrayList<>();
            for (int i = n; i >= 2; i--) {
                int num = target * 2 % i;
                if ( num == 0 && ((target * 2 / i) - i + 1) %2 == 0){
                    int itemIndex = ((target * 2 / i) - i + 1) / 2;
                    if (itemIndex >= 1){
                        int[] temp = new int[i];
                        for (int j = 0; j < i; j++) {
                            temp[j] = itemIndex ++;
                        }
                        list.add(temp);
                    }
                }

            }
            return list.toArray(new int[list.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
