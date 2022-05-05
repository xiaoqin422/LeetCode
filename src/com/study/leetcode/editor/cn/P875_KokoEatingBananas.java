package com.study.leetcode.editor.cn;
//<p>珂珂喜欢吃香蕉。这里有 <code>n</code> 堆香蕉，第 <code>i</code> 堆中有&nbsp;<code>piles[i]</code>&nbsp;根香蕉。警卫已经离开了，将在 <code>h</code> 小时后回来。</p>
//
//<p>珂珂可以决定她吃香蕉的速度 <code>k</code> （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 <code>k</code> 根。如果这堆香蕉少于 <code>k</code> 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。&nbsp;&nbsp;</p>
//
//<p>珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。</p>
//
//<p>返回她可以在 <code>h</code> 小时内吃掉所有香蕉的最小速度 <code>k</code>（<code>k</code> 为整数）。</p>
//
//<p>&nbsp;</p>
//
//<ul>
//</ul>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>piles = [3,6,7,11], h = 8
//<strong>输出：</strong>4
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>piles = [30,11,23,4,20], h = 5
//<strong>输出：</strong>30
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>piles = [30,11,23,4,20], h = 6
//<strong>输出：</strong>23
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
//	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 289</li><li>👎 0</li></div>

/**
 * [875]koko-eating-bananas
 * @author 秦笑笑
 * @date 2022-05-05 20:40:35
 */
public class P875_KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new P875_KokoEatingBananas().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 最小速度和最大速度（一次吃最大一堆香蕉）
        int left = 1,right = 1000000000 + 1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (f(piles,mid) <= h){ //单调递减函数  寻找左边界
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

        /**
         * 设置单调函数 f（x），
         * @param piles piles用于计算f（x）的结果
         * @param k 速度
         * @return 所需要的时间
         */
    private int f(int[] piles,int k){
        int hours = 0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k > 0) hours ++;
        }
        return hours;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
