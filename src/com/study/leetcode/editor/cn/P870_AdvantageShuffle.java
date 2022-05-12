package com.study.leetcode.editor.cn;
//<p>给定两个大小相等的数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>，<code>nums1</code>&nbsp;相对于 <code>nums</code>&nbsp;的<em>优势</em>可以用满足&nbsp;<code>nums1[i] &gt; nums2[i]</code>&nbsp;的索引 <code>i</code>&nbsp;的数目来描述。</p>
//
//<p>返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace" size="1"><span style="background-color: rgb(249, 242, 244);">nums1</span></font>&nbsp;的<strong>任意</strong>排列，使其相对于 <code>nums2</code>&nbsp;的优势最大化。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//<strong>输出：</strong>[2,11,7,15]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//<strong>输出：</strong>[24,32,8,12]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums1.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>nums2.length == nums1.length</code></li>
//	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>排序</li></div></div><br><div><li>👍 182</li><li>👎 0</li></div>

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * [870]advantage-shuffle
 * @author 秦笑笑
 * @date 2022-05-06 08:43:28
 */
public class P870_AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new P870_AdvantageShuffle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a1,int[] a2)->a2[1] - a1[1]);
        for (int i = 0; i < nums2.length; i++) {
            queue.offer(new int[]{i,nums2[i]});
        }
        int[] ans = new int[nums1.length];
        int left = 0,right = nums1.length - 1;
        while (left <= right){
            int t = 0;
            int[] poll = queue.poll();
            if (nums1[right] > poll[1]){
               t = right --;
            }else {
                t= left ++;
            }
            ans[poll[0]] = nums1[t];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
