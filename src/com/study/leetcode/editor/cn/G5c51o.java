//<p>给定一个整数数组 <code>nums</code> 和一个整数 <code>k</code>&nbsp;，请返回其中出现频率前 <code>k</code> 高的元素。可以按 <strong>任意顺序</strong> 返回答案。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入: </strong>nums = [1,1,1,2,2,3], k = 2
//<strong>输出: </strong>[1,2]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入: </strong>nums = [1], k = 1
//<strong>输出: </strong>[1]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>k</code> 的取值范围是 <code>[1, 数组中不相同的元素的个数]</code></li>
//	<li>题目数据保证答案唯一，换句话说，数组中前 <code>k</code> 个高频元素的集合是唯一的</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>所设计算法的时间复杂度 <strong>必须</strong> 优于 <code>O(n log n)</code> ，其中 <code>n</code><em>&nbsp;</em>是数组大小。</p>
//
//<p>&nbsp;</p>
//
//<p><meta charset="UTF-8" />注意：本题与主站 347&nbsp;题相同：<a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">https://leetcode-cn.com/problems/top-k-frequent-elements/</a></p>
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>分治</li><li>桶排序</li><li>计数</li><li>快速选择</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 26</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.*;

/**
 * [剑指 Offer II 060]出现频率最高的 k 个数字
 * @author 秦笑笑
 * @date 2022-04-17 14:10:02
 */
public class G5c51o {
    public static void main(String[] args) {
        Solution solution = new G5c51o().new Solution();
        int[] ints = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 记录各个数组出现的次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((number1,number2)->
            map.get(number1).equals(map.get(number2))? number1.compareTo(number2) : map.get(number1) - map.get(number2)
        );
        for (Integer key : map.keySet()) {
            queue.offer(key);
            if (queue.size() > k) queue.poll();
        }

        int[] arr = new int[k];
        while (!queue.isEmpty()){
            arr[--k] = queue.poll();
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
