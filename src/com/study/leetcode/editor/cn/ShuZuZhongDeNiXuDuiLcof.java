//<p>在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre><strong>输入</strong>: [7,5,6,4]
//<strong>输出</strong>: 5</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= 数组长度 &lt;= 50000</code></p>
//<div><div>Related Topics</div><div><li>树状数组</li><li>线段树</li><li>数组</li><li>二分查找</li><li>分治</li><li>有序集合</li><li>归并排序</li></div></div><br><div><li>👍 715</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [剑指 Offer 51]数组中的逆序对
 * @author 秦笑笑
 * @date 2022-04-23 15:08:18
 */
public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));;
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int sum = 0;
    public int reversePairs(int[] nums) {
        margeSort(nums,0,nums.length - 1);
        return sum;
    }
    private void margeSort(int[] nums,int low,int high){
        if (low < high){
            int mid = (high + low) / 2;
            margeSort(nums,low,mid);
            margeSort(nums,mid + 1,high);
            marge(nums,low,high);
        }

    }
    private void marge(int[] nums,int left,int right){
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        int l = left;
        int r = mid + 1;
        Queue<Integer> queue = new LinkedList<>();
        while (l <= mid && r <= right){
            if (nums[l] > nums[r]){
                queue.offer(nums[l++]);
                sum += right - r + 1;
            }else {
                queue.offer(nums[r++]);
            }
        }
        while (l <= mid){
            queue.offer(nums[l++]);
        }
        while (r <= right){
            queue.offer(nums[r++]);
        }
        for (int i = left; i <= right && !queue.isEmpty(); i++) {
            nums[i] = queue.poll();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
